import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(String name) {
        this(name, 0, 0.0);
    }

    public Employee(String name, int id) {
        this(name, id, 0.0);
    }

    public Employee(String name, int id, double salary) {
        if (salary < 0) {
            throw new ArithmeticException("Salary cannot be less than 0");
        }
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee Name: " + this.name + "\nID: " + this.id + "\nSalary: " + this.salary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of employee: ");
        String name = scanner.nextLine();
        System.out.println("Enter the ID of employee: ");
        int id = scanner.nextInt();
        System.out.println("Enter the salary of employee: ");
        double salary = scanner.nextDouble();
        Employee emp3 = new Employee(name, id, salary);
        scanner.close();
        System.out.println("Employee created with name, id and salary:-");
        emp3.display();
    }
}
