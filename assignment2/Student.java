import java.util.Scanner;

public class Student {

    private String name;
    private int rollNo;
    private int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getRollNo() {
        return this.rollNo;
    }

    public int getAge() {
        return this.age;
    }

    public void display() {
        System.out.println("Name: " + this.name + "\nRoll Number: " + this.rollNo + "\nAge: " + this.age);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String name = scanner.next();
        System.out.print("Enter the roll number of " + name + ": ");
        int rollNo = scanner.nextInt();
        System.out.print("Enter the age of " + name + ": ");
        int age = scanner.nextInt();
        scanner.close();

        Student student = new Student(name, rollNo, age);
        System.out.println("Displaying information: ");
        student.display();
    }

}