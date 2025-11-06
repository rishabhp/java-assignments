import java.util.Arrays;

public class AnagramCheck {
    private String str1;
    private String str2;
    
    public AnagramCheck(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }
    
    public boolean isAnagram() {
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        
        char []c1 = s1.toCharArray();
        char []c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        return Arrays.equals(c1, c2);
    }
    
    public static void main(String args[]) {
        AnagramCheck ac = new AnagramCheck("Listen", "Silent");
        
        if (ac.isAnagram()) {
            System.out.println("Listen and Silent are anagram");
        } else {
            System.out.println("Listen and Silent are not anagram");
        }
    }
}
