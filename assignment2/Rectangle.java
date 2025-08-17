import java.util.Scanner;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int calculateArea() {
        return this.length * this.width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the width of rectangle: ");
        int width = scanner.nextInt();
        scanner.close();

        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("Area of the rectangle is " + rectangle.calculateArea());
    }
}
