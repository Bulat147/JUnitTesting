/** ������ ���������:
 *      1) @Before (JUnit4) = @BeforeEach(JUnit5) - ����������� ����� ������ ������
 *      2) @BeforeClass (JUnit4) = @BeforeAll(JUnit5) - ����������� ����� ����� ������� ���� ���� ���.
 *         ��������, ��� ����������� ��.
 *
 *      3) @After (JUnit4) = @AfterEach (JUnit5) - ����������� ����� ������� �����
 *      4) @AfterClass (JUnit4) = @AfterAll(JUint5) - ����������� ����� ���� ������ ���� ���� ���.
 *         ��������, ��� ���������� ��.
 * */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest { // � ������� ���� ���� ����� ����� �� ������ � ������� Calculator,
            // �������� �� ������ ����� �� �������� ������ ������ Calculator � �����-�� �� ��� �������
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() { // ����� �����, ����� ������ ����� � ����� ������ ���� static
        System.out.println("������������ � ��������� ��.");
    }

    // ��������� ��� ������ ������� - BeforeEach
    @BeforeEach
    void setUp() { // ������ ��� ����� �� ����, ���� ����� ���� � � ���� ������ ����� ����������������
        calculator = new Calculator();
        System.out.println("������ �����");
    }

    // ��������� ��� ����� - Test
    @Test
    void add() {
        // ���� ����� ����� �� ������ � ������� add � ������ Calculator,
        // �� ������ �������� � ��� � �������� Calculator � ��� � ���� ������� �������� ���������� � ��
        int expected;
        int result;
        for (int i=1; i<50; i++){
            expected = i + (i-1);
            result = calculator.add(i, i-1);
            assertEquals(expected, result);
        }
    }

    //��-�������� ����� ����� ������ ��� �������� (Behave), � �� ������� ����� ����� � ����� �����
    @Test
    void whenInputIncorrectValueToAddThenThrowException(){
        // 1-�� ����� ������������ ������ ����������
        boolean wasException = false;
        try{
            calculator.add("ggdfg", "45");
        }catch(NumberFormatException e){
            wasException = true;
        }
        assertTrue(wasException);
    }

    // 2-�� ������ ������������ ������ ���������� � JUnit5 - assertThrows(����� ����������, ������-��������� ��� ��������)
    // @Test(expected = NumberFormatException.class) - ��� ����� ���� ������ � JUnit4
    @Test
    void whenIncorrectValueToMultiplyThenThrowException(){
        // ������ NumberFormatException ����� �������� ����� �������� ���� ���������� Exception
        // ��� ����� ��� ���� � �������� ����� �������� ���� "��������" �� ��������� - Throwable
        NumberFormatException thrown = assertThrows(NumberFormatException.class, () ->{
            // ��� ����� � �������� ����� ���� ��� �������� ������������ ������-��������� ��� ����������
            calculator.multiply("45", "ssvfv");
        });
        // ����� ���� �� ��������� thrwon, � ������ ������� assertThrows(), �� ��� ���� ������ - ��������� ���������
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
            // �.�. ��� double ����� ���� �����������, �� ���������� �� ����� � ������ �����������
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
            // �.�. ��� double ����� ���� �����������, �� ���������� �� ����� � ������ �����������
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
        System.out.println("���� ����������");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("����������� �� ��������� ��.");
    }
}