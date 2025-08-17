import java.util.Scanner;

public class CalculateFactorial {
    
    static long calculateFactorial(int n) {
        long accumulator = 1;
        for (int i = 2; i <= n; i++) {
            accumulator *= i;
        }
        return accumulator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:- ");
        int num = scanner.nextInt();
        scanner.close();
        System.out.println("Factorial of " + num + " is " + CalculateFactorial.calculateFactorial(num));
    }
}
