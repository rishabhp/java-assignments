public class StringCleaner {
    
    public void cleanText(String data) {
        String cleaned = data
            .replaceAll("\\d", "")
            .replaceAll("\\p{Punct}", "")
            .replaceAll("\\s+", " ")
            .trim();
        System.out.println(cleaned);
    }
    
    public static void main(String args[]) {
        String str = "Hello!!! 123   world... How   are you??";
        StringCleaner sc = new StringCleaner();
        sc.cleanText(str);
    }
}
