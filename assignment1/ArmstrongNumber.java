import java.util.Scanner;

public class ArmstrongNumber {
    static boolean isArmstrong(int n) {
        int temp = n, digits = 0, accumulator = 0;
        while (temp > 0) {
            digits += 1;
            temp /= 10;
        }
        temp = n;

        while (temp != 0) {
            accumulator += Math.pow(temp % 10, digits);
            temp /= 10;
        } 
        return accumulator == n;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        if (ArmstrongNumber.isArmstrong(num)) {
            System.out.println(num + " is an armstrong number");
        } else {
            System.out.println(num + " is not an armstrong number");
        }
    }
}
