import java.util.Scanner;

public class PalindromeSubstrings {
    private String str;

    public PalindromeSubstrings(String str) {
        this.str = str;
    }

    private boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public void printPalindromeSubstrings() {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String tempStr = str.substring(i, j+1);
                if (isPalindrome(tempStr)) {
                    System.out.println(tempStr + " is a Palindrome Substring, starting from index " + i + " and ending at index " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();
        PalindromeSubstrings ps = new PalindromeSubstrings(str);
        ps.printPalindromeSubstrings();
    }
}
