import java.util.Scanner;

public class CalculatePower {
    static long calculatePower(int base, int power) {
        long accumulator = 1;
        for (int i = 0; i < power; i++) {
            accumulator *= base;
        }
        return accumulator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base: ");
        int base = scanner.nextInt();
        System.out.println("Enter the power: ");
        int power = scanner.nextInt();
        System.out.println(base + "^" + power + ": " + CalculatePower.calculatePower(base, power));
        scanner.close();
    }
}
