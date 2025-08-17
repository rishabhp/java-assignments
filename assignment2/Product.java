import java.util.Scanner;

public class Product {
    private String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void display() {
        System.out.println("Product Name: " + this.productName + "\nProduct Price: " + this.productPrice);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product []products = new Product[3];
        for (int i = 0; i < products.length; i++) {
            System.out.println("\nEnter the information of product number " + (i + 1));
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            products[i] = new Product(name, price);
        }
        scanner.close();

        for (int i = 0; i < products.length; i++) {
            System.out.println("\nInformation of product number " + (i + 1) + ":-");
            products[i].display();
        }
    }
}
