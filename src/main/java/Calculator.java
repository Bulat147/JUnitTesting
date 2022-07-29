public class Calculator {

    public int add(int a, int b){
        return a+b;
    }

    public int add(String a, String b){
        // ���� user ���� ������������ ������, �� ����� �������� ����������
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        return numA + numB;
    }

    public int minus(int a, int b){
        return a-b;
    }

    public double divide(double firstNum, double secondNum){
        return firstNum/secondNum; // ����� ����� ���������� �����������, �.�. �������� � double
    }

    public double multiply(double firstNum, double secondNum){
        return firstNum * secondNum; // ���� ����� ���������� �����������
    }

    public double multiply(String a, String b){
        int firstNum = Integer.parseInt(a);
        int secondNum = Integer.parseInt(b);
        return firstNum * secondNum;
    }

    public double degree(double a, int b){
        double temp = a;
        for (int i=0; i<b-1; i++){
            a = temp*a; // ���� � �������������
        }
        return a;
    }
}
