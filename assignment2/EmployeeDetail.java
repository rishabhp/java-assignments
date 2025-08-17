class Address {

    private String area;
    private String state;
    private String country;
    private long pinCode;

    public Address(String area, String state, String country, long pinCode) {
        this.area = area;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getArea() {
        return this.area;
    }

    public String getState() {
        return this.state;
    }

    public String getCountry() {
        return this.country;
    }

    public long getPinCode() {
        return this.pinCode;
    }
}

public class EmployeeDetail {
    private int empId;
    private String empName;
    private Address empAddress;
    private double empSalary;

    public EmployeeDetail(int id, String name, String area, String state, String country, long pinCode, double salary) {
        this.empId = id;
        this.empName = name;
        this.empAddress = new Address(area, state, country, pinCode);
        this.empSalary = salary;
    }

    public void display() {
        System.out.println("Employee ID: " + this.empId + "\nEmployee Name: " + this.empName + 
                           "\nArea of Residence: " + this.empAddress.getArea() + 
                           "\nState of Residence: " + this.empAddress.getState() + 
                           "\nCountry of Residence: " + this.empAddress.getCountry() + 
                           "\nPin-Code: " + this.empAddress.getPinCode() + 
                           "\nSalary: " + this.empSalary);
    }

    public static void main(String[] args) {
        EmployeeDetail empDetail = new EmployeeDetail(1, "Matin", "Bijapur", "Gujarat", "India", 380011, 50000);

        empDetail.display();
    }

}
