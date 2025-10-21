import java.util.Scanner;

public class CharFrequency {
    public static void frequencyCounter(String str) {
        str = str.toLowerCase();
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            int alphabetCounter = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == alphabet) {
                    alphabetCounter++;
                }
            }
            System.out.println("Count of '" + alphabet + "' : " + alphabetCounter);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        frequencyCounter(str);
    }
}
