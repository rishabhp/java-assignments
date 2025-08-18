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
    
}