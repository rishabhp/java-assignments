class Marks {
    private String subjectName;
    private int marks;

    public Marks(String subjectName, int marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public int getMarks() {
        return this.marks;
    }
}

class Student {

    private String studentName;
    private Marks[] marks;

    public Student(String name, Marks[] marks) {
        this.studentName = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Name: " + this.studentName);
        for (Marks mark : marks) {
            System.out.println("Subject Name: " + mark.getSubjectName() + "\t\t\tMarks: " + mark.getMarks());
        }
        System.out.println("Total Marks: " + this.getTotalMarks() + "\nAverage Marks: " + this.getAverageMarks());
    }

    public int getTotalMarks() {
        int sum = 0;
        for (Marks mark : marks) {
            sum += mark.getMarks();
        }
        return sum;
    }

    public double getAverageMarks() {
        return (double) this.getTotalMarks() / this.marks.length;
    }
}


public class MarksMain {
    public static void main(String[] args) {
        Marks []student1Marks = {
            new Marks("Social Science", 82),
            new Marks("Science", 73),
            new Marks("Maths", 91)
        };

        Marks []student2Marks = {
            new Marks("Java - Theory", 82),
            new Marks("Data Analytics", 88),
            new Marks("Machine Learning - Theory", 90)
        };

        Student []students = {
            new Student("Krish", student1Marks),
            new Student("Sumer", student2Marks)
        };

        for (Student student : students) {
            student.display();
            System.out.println("\n");
        }
    }
}
