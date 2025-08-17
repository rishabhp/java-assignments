import java.util.Scanner;

public class FibonacciSequence {

    static void displayFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        int a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + ", ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number till which you want fibonacci sequence:");
        int num = scanner.nextInt();
        scanner.close();
        FibonacciSequence.displayFibonacci(num);
    }
}
