public class PasswordAnalyzer {
    private String password;
    public PasswordAnalyzer(String password) {
        this.password = password;
    }
    public void analyze() {
        int minLenght = 0, hasUpperAndLower = 0, hasSpecialChars = 0;
        
        if (password.length() >= 8) {
            minLenght = 1;
        }
        
        if (password.matches("(?=.*[A-Z])(?=.*[a-z]).*")) {
            hasUpperAndLower = 1;
        }
        
        if (password.matches("[0-9]") && password.matches("[^a-zA-Z0-9]")) {
            hasSpecialChars = 1;
        }
        
        int score = minLenght + hasUpperAndLower + hasSpecialChars;
        
        if (score == 0) {
            System.out.println("Password is invalid (doesnt matches any of the required criteria)!");
        } else if (score == 1) {
            System.out.println("Password Strength: Weak!");
        } else if (score == 2) {
            System.out.println("Password Strength: Moderate!");
        } else {
            System.out.println("Password Strength: Strong!");
        }
    }
    public static void main(String args[]) {
        PasswordAnalyzer pa = new PasswordAnalyzer("rishabh1");
        pa.analyze();
    }
}
