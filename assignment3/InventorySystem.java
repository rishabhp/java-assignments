
import java.util.HashSet;
import java.util.Objects;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Product p = (Product) other;
        return this.name.equals(p.name) && this.price == p.price && this.quantity == p.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.price, this.quantity);
    }

    @Override
    public String toString() {
        return "Product Name: " + this.name + "\nPrice: " + this.price + "\nQuantity: " + this.quantity;
    }
}

class Inventory {
    private HashSet<Product> products;

    public Inventory() {
        products = new HashSet<>();
    }

    public Inventory(HashSet<Product> products) {
        this.products = products;
    }

    public boolean addProduct(String name, double price) {
        Product p = new Product(name, price, 1);
        return products.add(p);
    }

    public boolean addProduct(String name, double price, int quantity) {
        Product p = new Product(name, price, quantity);
        return products.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVENTORY:- ")
            .append("\n---------------------------------------------------------------------------------------------\n");

        for (Product product : this.products) {
            sb.append(product)
                .append("\n---------------------------------------------------------------------------------------------\n");
        }
        return sb.toString();
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct("Chair", 1500, 5);
        inventory.addProduct("Table", 5500, 3);
        inventory.addProduct("Drawer", 10000, 2);
        inventory.addProduct("Chair", 1500, 5);
        System.out.println(inventory);
    }
}
