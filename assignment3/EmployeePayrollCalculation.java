import java.util.ArrayList;

abstract class Employee {
    protected int id;
    protected String name;
    protected double salary;

    abstract public void calculateSalary();

    @Override
    public String toString() {
        return "Employee ID: " + id + 
                "\nEmployee Name: " + name + 
                "\nEmployee Salary: " + salary;
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public void calculateSalary() {
        this.salary = monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateSalary() {
        this.salary = this.hourlyRate * this.hoursWorked;
    }
}

public class EmployeePayrollCalculation {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee(1, "Krish Agrawal", 50000));
        employees.add(new PartTimeEmployee(2, "Kinjal Shah", 60, 200));
        employees.add(new FullTimeEmployee(3, "Dhanraj Patel", 60000));
        employees.add(new PartTimeEmployee(4, "Abhijeet Routh", 80, 175));

        System.out.println("Displaying information for salaries:-");
        for (Employee employee : employees) {
            employee.calculateSalary();
            System.out.println(employee);
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}
