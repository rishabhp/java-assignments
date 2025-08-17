import java.util.Scanner;

public class Car {
    private String brandName;
    private String modelName;
    
    public Car() {
        this.brandName = "NULL";
        this.modelName = "NULL";
    }

    public Car(String brandName, String modelName) {
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public void display() {
        System.out.println("Brand Name: " + this.brandName + "\nModel Name: " + this.modelName);
    }

    public static void main(String[] args) {
        Car car1 = new Car();

        System.out.println("Created a car object with default constructor: ");
        car1.display();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the brand of car: ");
        String brandName = scanner.nextLine();
        System.out.print("Enter the model name of car: ");
        String modelName = scanner.nextLine();
        scanner.close();

        Car car2 = new Car(brandName, modelName);
        System.out.println("Created a car object parameterized constructor: ");
        car2.display();
    }
}
