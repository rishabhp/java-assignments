import java.util.Scanner;

public class Shape {
    private double radius;
    private double length;
    private double breadth;

    public Shape(double radius) {
        this.radius = radius;
        this.length = this.breadth = -1;
        this.area(this.radius);
    }

    public Shape(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
        this.radius = -1;
        this.area(this.length, this.breadth);
    }

    public void area(double radius) {
        System.out.println("Area of Circle with radius " + radius + " is " + 3.14 * radius * radius);
    } 

    public void area(double length, double breadth) {
        System.out.println("Area of Rectangle with length " + length + " and breadth " + breadth + " is " + (length * breadth));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of circle: ");
        double r = scanner.nextDouble();
        Shape circle = new Shape(r);

        System.out.println("Enter the length and breadth of rectangle: ");
        double l = scanner.nextDouble();
        double b = scanner.nextDouble();
        Shape rectangle = new Shape(l, b);
        scanner.close();

    }
}
