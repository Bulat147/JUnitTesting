import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest { // � ������� ���� ���� ����� ����� �� ������ � ������� Calculator,
            // �������� �� ������ ����� �� �������� ������ ������ Calculator � �����-�� �� ��� �������
    private Calculator calculator;

    // ���������� ��� ������ - BeforeEach
    @BeforeEach
    void setUp() { // ������ ��� ����� �� ����, ���� ����� ���� � � ���� ������ ����� ����������������
        calculator = new Calculator();
    }

    // ���������� ��� ����� - Test
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
}