import java.util.ArrayList;
class Product {

    private String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    @Override
    public String toString() {
        return "Product Name: " + this.productName + "\nPrice: " + this.productPrice;
    }
}

class Cart<T> {
    private ArrayList<T> list;

    public Cart() {
        list = new ArrayList<>();
    }

    public void addItem(T item) {
        list.add(item);
    }

    public boolean removeItem(T item) {
        return list.remove(item);
    }

    public ArrayList<T> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart Items:-\n----------------------------------------------------------------------------\n");
        for (T item : list) {
            sb.append(item).append("\n\n");
        }
        return sb.toString();
    }
}

public class GenericClass {
    public static void main(String[] args) {
        Cart<Product> cart = new Cart<>();
        Product p1 = new Product("Chair", 1000);
        Product p2 = new Product("Table", 3000);
        cart.addItem(p1);
        cart.addItem(p2);
        System.err.println(cart);
        double sum = 0;
        for (Product p : cart.getList()) {
            sum += p.getProductPrice();
        }
        System.out.println("Total Price: " + sum);

        System.out.println("\nRemoving chair from cart\n");
        cart.removeItem(p1);
        System.out.println(cart);
    }
}