public class Customer {
    
    private String name;
    private int age;
    
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name) {
        this(name, 0);
    }

    public Customer(int age) {
        this("NULL", age);
    }

    public Customer() {
        this("NULL", 0);
    }

    public void display() {
        System.out.println("Customer Name: " + this.name + "\nAge: " + this.age);
    }

    public static void main(String[] args) {
        Customer cust1 = new Customer("Rohan", 22);
        System.out.println("Created a customer with both name and age:-");
        cust1.display();

        Customer cust2 = new Customer("Kirtan");
        System.out.println("Created a customer with only name:-");
        cust2.display();

        Customer cust3 = new Customer();
        System.out.println("Created a customer with neither name nor age:-");
        cust3.display();
    }
}
