import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest { // В обычном виде этот класс никак не связан с классом Calculator,
            // свяжется он только когда мы создадим объект класса Calculator в каком-то из его методов
    private Calculator calculator;

    // Дескриптор для сетапа - BeforeEach
    @BeforeEach
    void setUp() { // Сделал это чисто по фану, хотя можно было и в поле класса теста инициализировать
        calculator = new Calculator();
    }

    // Дескриптор для теста - Test
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
}