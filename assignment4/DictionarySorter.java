public class DictionarySorter {
    private String[] words;

    public DictionarySorter(String[] words) {
        this.words = words;
    }

    public void sortWords() {
        int n = words.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words[j].compareTo(words[j+1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }
    }

    public void display() {
        sortWords();

        for (String word : words) {
            System.out.print(word + "\t");
        }
        System.out.println("\nSmallest Word: " + words[0]);
        System.out.println("Longest Word: " + words[words.length-1]);
    }

    public static void main(String[] args) {
        String[] words = {
            "Car",
            "Aeroplane",
            "Truck",
            "Motorbike"
        };

        DictionarySorter ds = new DictionarySorter(words);
        ds.display();
    }
}
