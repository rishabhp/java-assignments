abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle (radius=" + radius + ", area=" + this.calculateArea() + ", perimeter=" + this.calculatePerimeter() + ")";
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }

    @Override
    public String toString() {
        return "Rectangle (length=" + length + ", breadth=" + breadth + ", area=" + this.calculateArea() + ", perimeter=" + this.calculatePerimeter() + ")";
    }
}

class Triangle extends Shape {

    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return "Triangle (sides=(" + a + ", " + b + ", " + c + "), area=" + this.calculateArea() + ", perimeter=" + this.calculatePerimeter() + ")";
    }
}

public class AreaPerimeterCalculation {
    public static void main(String[] args) {
        Shape []shapes = {
            new Circle(4.5),
            new Rectangle(2.2, 4),
            new Triangle(3, 4, 5),
            new Circle(1.5),
            new Rectangle(4, 5),
            new Triangle(5, 12, 13)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
