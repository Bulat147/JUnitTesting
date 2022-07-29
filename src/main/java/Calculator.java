public class Calculator {

    public int add(int a, int b){
        return a+b;
    }

    public int add(String a, String b){
        // Если user ввел некорректную строку, то пусть вылетает исключение
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        return numA + numB;
    }

    public int minus(int a, int b){
        return a-b;
    }

    public double divide(double firstNum, double secondNum){
        return firstNum/secondNum; // Здесь могут возникнуть погрешности, т.к. работаем с double
    }

    public double multiply(double firstNum, double secondNum){
        return firstNum * secondNum; // Тоже могут возникнуть погрешности
    }

    public double multiply(String a, String b){
        int firstNum = Integer.parseInt(a);
        int secondNum = Integer.parseInt(b);
        return firstNum * secondNum;
    }

    public double degree(double a, int b){
        double temp = a;
        for (int i=0; i<b-1; i++){
            a = temp*a; // Тоже с погрешностями
        }
        return a;
    }
}
