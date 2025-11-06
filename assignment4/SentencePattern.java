import java.util.Scanner;

public class SentencePattern {
    private String str;

    public SentencePattern(String str) {
        this.str = str;
    }

    private String reverseAndCapitalizeFirstLetter(String s) {
        String word = new StringBuilder(s).reverse().toString();
        String result = word.substring(0, 1).toUpperCase() + word.substring(1);
        return result;
    }

    public void sentencePattern() {
        String[] sentenceParts = str.trim().toLowerCase().split("\\s+");
        for (String word : sentenceParts) {
            System.out.print(reverseAndCapitalizeFirstLetter(word) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        SentencePattern sp = new SentencePattern(scanner.nextLine());
        sp.sentencePattern();
        scanner.close();
    }
}
