
import java.util.ArrayList;
import java.util.Scanner;

abstract class Vehicle {
    protected String registrationNumber;
    protected String brand;
    protected double dailyRentalRate;

    public Vehicle(String brand, double dailyRentalRate, String registrationNumber) {
        this.brand = brand;
        this.dailyRentalRate = dailyRentalRate;
        this.registrationNumber = registrationNumber;
    }

    abstract public double calculateRentalCost(int days);

    @Override
    public String toString() {
        return "Reg. No: " + this.registrationNumber + ", Brand: " + this.brand;
    }
}

class Car extends Vehicle {
    private int seatingCapacity;

    public Car(int seatingCapacity, String brand, double dailyRentalRate, String registrationNumber) {
        super(brand, dailyRentalRate, registrationNumber);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double base_cost = this.dailyRentalRate * days;
        double total_cost = (days > 7)? 0.90 * base_cost : base_cost;
        return total_cost;
    }

    @Override
    public String toString() {
        return "Vehicle: Car, " + super.toString() + ", Seating Capacity: " + this.seatingCapacity;
    }
}

class Motorbike extends Vehicle {
    private int engineCapacity;

    public Motorbike(int engineCapacity, String brand, double dailyRentalRate, String registrationNumber) {
        super(brand, dailyRentalRate, registrationNumber);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double base_cost = this.dailyRentalRate * days;
        double total_cost = (this.engineCapacity > 500)? base_cost + (200 * days) : base_cost;
        return total_cost;
    }

    @Override
    public String toString() {
        return "Vehicle: Motorbike, " + super.toString() + ", Engine Capacity: " + this.engineCapacity + "cc";
    }
}

class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(int loadCapacity, String brand, double dailyRentalRate, String registrationNumber) {
        super(brand, dailyRentalRate, registrationNumber);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double base_cost = this.dailyRentalRate * days;
        double total_cost = (this.loadCapacity > 5000)? 1.15 * base_cost : base_cost;
        return total_cost;
    }

    @Override
    public String toString() {
        return "Vehicle: Truck, " + super.toString() + ", Load Capacity: " + this.loadCapacity + "kg";
    }
}



public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        vehicles.add(new Car(5, "Toyota", 1500, "GJ05AB1234"));
        vehicles.add(new Motorbike(600, "Yamaha", 800, "MH12XY9876"));
        vehicles.add(new Truck(6000, "Tata", 3000, "DL01ZZ4321"));

        for (Vehicle vehicle : vehicles) {
            System.out.println("\n" + vehicle);
            System.out.print("Enter number of rental days: ");
            int days = scanner.nextInt();
            double cost = vehicle.calculateRentalCost(days);
            System.out.println("Total Rental Cost For " + days + " Days: " + cost);
        }

        scanner.close();
    }
}
