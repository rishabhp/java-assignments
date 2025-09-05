interface Discountable {
    double getDiscountPrice();
    String getType();
}

class Electronics implements Discountable {
    private double price;

    public Electronics(double price) {
        this.price = price;
    }

    @Override
    public double getDiscountPrice() {
        return price * 0.9;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}

class Clothing implements Discountable {
    private double price;

    public Clothing(double price) {
        this.price = price;
    }

    @Override
    public double getDiscountPrice() {
        return price * 0.8;
    }

    @Override
    public String getType() {
        return "Clothing";
    }
}

class Grocery implements Discountable {
    private double price;

    public Grocery(double price) {
        this.price = price;
    }

    @Override
    public double getDiscountPrice() {
        return price * 0.95; // 5% discount
    }

    @Override
    public String getType() {
        return "Grocery";
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Discountable[] items = {
            new Electronics(10000),
            new Clothing(2000),
            new Grocery(500)
        };

        for (Discountable item : items) {
            System.out.println(item.getType() + " Item " + "Final Price: Rs." + item.getDiscountPrice());
        }
    }
}