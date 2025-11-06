import java.util.Scanner;

public class UniqueWordExtractor {
    private String str;

    public UniqueWordExtractor(String str) {
        this.str = str;
    }

    public void extractUniqueWords() {
        String []uniqueWords = new String[str.length()];
        int uniqueCount = 0;
        for (String word : str.split(" ")) {
            boolean notInArray = true;
            for (int i = 0; i < uniqueCount; i++) {
                if (word.equalsIgnoreCase(uniqueWords[i])) {
                    notInArray = false;
                    break;
                }
            }
            if (notInArray) {
                uniqueWords[uniqueCount] = word;
                uniqueCount++;
            }
        }
        System.out.println("Unique words in encountered order:-");
        for (int i =0; i < uniqueCount; i++) {
            System.out.println(uniqueWords[i]);
        }
    }
    
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        UniqueWordExtractor uwe = new UniqueWordExtractor(scanner.nextLine());
        scanner.close();
        uwe.extractUniqueWords();
    }
}