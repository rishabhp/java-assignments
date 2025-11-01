import java.util.Scanner;

public class SubstringFinder {
    public void findOccurrences(String main, String sub) {
        int index = 0;

        while (index < main.length()) {
            int foundIndex = main.indexOf(sub, index);
            if (foundIndex == -1) {
                return;
            }
            int endIndex = foundIndex + sub.length() - 1;
            index = foundIndex + 1;

            System.out.println("Substring found at start index " + foundIndex + " and end index " + endIndex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String main = scanner.nextLine();
        System.out.print("Enter the sub string: ");
        String sub = scanner.nextLine();
        scanner.close();
        SubstringFinder sf = new SubstringFinder();
        sf.findOccurrences(main, sub);
    }
}
