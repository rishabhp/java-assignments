import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be more than or equal to 18");
        }
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + this.name + "\nAge: " + this.age);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        scanner.close();

        try {
            Person person = new Person(name, age);
            person.display();
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
