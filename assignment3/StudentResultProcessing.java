import java.util.Scanner;

abstract class Student {
    protected  int rollNo;
    protected  String name;
    protected int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    abstract void calculateResult();
}

class UndergraduateStudent extends Student {
    public UndergraduateStudent(int rollNo, String name, int marks) {
        super(rollNo, name, marks);
    }

    @Override
    public void calculateResult() {
        System.out.println("UG Student: " + this.name + " (" + this.rollNo + ")");
        if (this.marks >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

class PostgraduateStudent extends Student {

    public PostgraduateStudent(int rollNo, String name, int marks) {
        super(rollNo, name, marks);
    }

    @Override
    public void calculateResult() {
        System.out.println("PG Student: " + this.name + " (" + this.rollNo + ")");
        if (this.marks >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

public class StudentResultProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student []students = new Student[5];

        for (int i =0; i < students.length; i++) {
            System.out.println("\nEnter information for student-" + (i+1));
            System.out.print("Enter the type of student (1 for UG, 2 for PG): ");
            int type = scanner.nextInt();

            if (type != 1 && type != 2) {
                System.out.println("Not a valid type! Try again!");
                i--;
                continue;
            }

            System.out.print("Enter the roll number for student: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the name for student: ");
            String name = scanner.nextLine();
            System.out.print("Enter the marks for " + name.toUpperCase() + ": ");
            int marks = scanner.nextInt();

            if (type == 1) {
                students[i] = new UndergraduateStudent(rollNo, name, marks);
            } else {
                students[i] = new PostgraduateStudent(rollNo, name, marks);
            }
        }
        scanner.close();

        for (Student student : students) {
            student.calculateResult();
        }
    }
}