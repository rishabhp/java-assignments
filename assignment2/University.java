import java.util.Scanner;

public class University {
    public final static String universityName = "Gujarat University";
    private String studentName;

    public University(String name) {
        this.studentName = name;
    }

    public void display() {
        System.out.println("Student Name: " + this.studentName + "\nUniversity: " + University.universityName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University student = new University("Rishabh");
        scanner.close();
        student.display();
    }
}
