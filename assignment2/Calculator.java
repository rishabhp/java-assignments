

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Adding two integers (5 and 6): " + Calculator.add(5, 6));
        System.out.println("Adding three integers (4, 9, 12): " + Calculator.add(4, 9, 12));
        System.out.println("Adding two doubles (3.34 and 12.12): " + Calculator.add(3.34, 12.12));
    }
}
