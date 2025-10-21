import java.util.Scanner;

public class StringCompare {
    private String str1;    
    private String str2;

    public StringCompare(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public void compareExact() {
        if (str1.equals(str2)) {
            System.out.println("Both the string are equal!");
        } else {
            System.out.println("The two strings are not equal!");
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);
        int lengthDifference = Math.abs(len1 - len2);
        int differenceCount = lengthDifference;

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differenceCount++;
            }
        }

        System.out.println("Number of different character: " + differenceCount);
    }

    public void compareIgnoreCase() {
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Both the string are equal!");
        } else {
            System.out.println("The two strings are not equal!");
        }
        int len1 = str1.length();
        int len2 = str2.length();
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        int minLength = Math.min(len1, len2);
        int lengthDifference = Math.abs(len1 - len2);
        int differenceCount = lengthDifference;

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differenceCount++;
            }
        }

        System.out.println("Number of different character: " + differenceCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2 Strings");
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();

        StringCompare sc = new StringCompare(s1, s2);
        System.out.println("Compare Exact:-");
        sc.compareExact();
        System.out.println("\nCompare Ignore Case:-");
        sc.compareIgnoreCase();
    }
}
