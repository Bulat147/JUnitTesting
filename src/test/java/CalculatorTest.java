/** Важное замечание:
 *      1) @Before (JUnit4) = @BeforeEach(JUnit5) - запускается перед каждым тестом
 *      2) @BeforeClass (JUnit4) = @BeforeAll(JUnit5) - запускается перед всеми тестами лишь один раз.
 *         Например, для подключения бд.
 *
 *      3) @After (JUnit4) = @AfterEach (JUnit5) - запускается после каждого теста
 *      4) @AfterClass (JUnit4) = @AfterAll(JUint5) - запускается после всех тестов лишь один раз.
 *         Например, для отключения бд.
 * */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest { // В обычном виде этот класс никак не связан с классом Calculator,
            // свяжется он только когда мы создадим объект класса Calculator в каком-то из его методов
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() { // Очень важно, чтобы сетапы перед и после класса были static
        System.out.println("Подключаемся к фальшивой бд.");
    }

    // Аннотация для сетапа методов - BeforeEach
    @BeforeEach
    void setUp() { // Сделал это чисто по фану, хотя можно было и в поле класса теста инициализировать
        calculator = new Calculator();
        System.out.println("Начало теста");
    }

    // Аннотация для теста - Test
    @Test
    void add() {
        // Этот метод никак не связан с методом add в классе Calculator,
        // мы просто работаем в нем с объектом Calculator и ещё у этих методов название одинаковое и всё
        int expected;
        int result;
        for (int i=1; i<50; i++){
            expected = i + (i-1);
            result = calculator.add(i, i-1);
            assertEquals(expected, result);
        }
    }

    //По-хорошему тесты нужно писать как сценарии (Behave), а не тестить целый метод в одном тесте
    @Test
    void whenInputIncorrectValueToAddThenThrowException(){
        // 1-ый метод тестирования вылета исключения
        boolean wasException = false;
        try{
            calculator.add("ggdfg", "45");
        }catch(NumberFormatException e){
            wasException = true;
        }
        assertTrue(wasException);
    }

    // 2-ой способ тестирования вылета исключения в JUnit5 - assertThrows(класс исключения, лямбда-выражение для проверки)
    // @Test(expected = NumberFormatException.class) - так можно было делать в JUnit4
    @Test
    void whenIncorrectValueToMultiplyThenThrowException(){
        // Вместо NumberFormatException можно написать класс родитель всех исключений Exception
        // или пойти ещё выше и написать класс родитель всех "поднятий" из программы - Throwable
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () ->{
            // Как видим в качестве блока кода для проверки используется лямбда-выражение без аргументов
            calculator.multiply("45", "ssvfv");
        });
        // можно было не создавать thrwon, а просто вызвать assertThrows(), но тут есть польза - получение сообщения
        System.out.println(thrown.getMessage());
    }

    @Test
    void minus(){
        int expected;
        int result;
        for (int i=1; i<50; i++){
            expected = i - (i-1);
            result = calculator.minus(i, i-1);
            assertEquals(expected, result);
        }
    }

    @Test
    void multiply(){
        double expected;
        double result;
        for (double i=1.5; i<50; i++){
            expected = i * (i-1);
            result = calculator.multiply(i, i-1);
            // Т.к. при double могут быть погрешности, то сравнивать их нужно с учетом погрешности
            assertEquals(expected, result, 0.000000001);
        }
    }

    @Test
    void divide(){
        double expected;
        double result;
        for (double i=1.5; i<50; i++){
            expected = i / (i-1);
            result = calculator.divide(i, i-1);
            // Т.к. при double могут быть погрешности, то сравнивать их нужно с учетом погрешности
            assertEquals(expected, result, 0.000000001);
        }
    }

    @Test
    void degree(){
        double expected = 25;
        double result = calculator.degree(5, 2);
        assertEquals(expected, result);

        double expected2 = 216;
        double result2 = calculator.degree(6, 3);
        assertEquals(expected2, result2);
    }

    @AfterEach
    void tearDown(){
        System.out.println("Тест завершился");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Отключаемся от фальшивой бд.");
    }
}