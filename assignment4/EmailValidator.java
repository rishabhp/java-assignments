import java.util.regex.*;

public class EmailValidator {
    private String email;

    public EmailValidator(String email) {
        this.email = email;
    }

    public void validate() {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!email.contains("@")) {
            System.out.println("Invalid: Missing '@' symbol.");
            return;
        }

        if (email.startsWith("@") || email.endsWith("@")) {
            System.out.println("Invalid: '@' cannot be at the start or end.");
            return;
        }

        int atIndex = email.indexOf('@');
        String domainPart = email.substring(atIndex + 1);
        if (!domainPart.contains(".")) {
            System.out.println("Invalid: Missing domain extension (e.g., '.com').");
            return;
        }

        if (email.matches(regex)) {
            System.out.println("Valid email address!");
        } else {
            System.out.println("Invalid: Email format is incorrect.");
        }
    }

    public static void main(String[] args) {
        EmailValidator e1 = new EmailValidator("john.doe@gmail.com");
        e1.validate();

        EmailValidator e2 = new EmailValidator("john.doe@gmail");
        e2.validate();

        EmailValidator e3 = new EmailValidator("johndoegmail.com");
        e3.validate();

        EmailValidator e4 = new EmailValidator("@example.com");
        e4.validate();
    }
}
