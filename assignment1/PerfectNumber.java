import java.util.Scanner;

public class PerfectNumber {
    static boolean isPerfect(int n) {
        int accumulator = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                accumulator += i;
            }
        }
        return accumulator == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        if (PerfectNumber.isPerfect(num)) {
            System.out.println(num + " is a perfect number");
        } else {
            System.out.println(num + " is not a perfect number");
        }
    }
}
