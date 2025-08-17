import java.util.Scanner;

public class PalindromeNumber {
    static boolean isPalindrome(int n) {
        int reverse_n = 0, temp = n;
        while (temp != 0) {
            reverse_n = (reverse_n * 10) + temp % 10;
            temp /= 10;
        }
        return reverse_n == n;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        if (PalindromeNumber.isPalindrome(num)) {
            System.out.println(num + " is a palindrome number");
        } else {
            System.out.println(num + " is not a palindrome number");
        }
    }
}
