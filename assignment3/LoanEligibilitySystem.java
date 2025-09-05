abstract class Loan {
    protected String customerName;
    protected double income;
    protected double loanAmount;

    public Loan(String customerName, double income, double loanAmount) {
        this.customerName = customerName;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public abstract boolean isEligible();

    @Override
    public String toString() {
        return customerName + " | Income: Rs." + income + " | Loan: Rs." + loanAmount;
    }
}

class HomeLoan extends Loan {
    public HomeLoan(String customerName, double income, double loanAmount) {
        super(customerName, income, loanAmount);
    }

    @Override
    public boolean isEligible() {
        return income >= 30000 && loanAmount <= income * 20;
    }
}

class CarLoan extends Loan {
    public CarLoan(String customerName, double income, double loanAmount) {
        super(customerName, income, loanAmount);
    }

    @Override
    public boolean isEligible() {
        return income >= 20000 && loanAmount <= income * 10;
    }
}

class EducationLoan extends Loan {
    public EducationLoan(String customerName, double income, double loanAmount) {
        super(customerName, income, loanAmount);
    }

    @Override
    public boolean isEligible() {
        return loanAmount <= income * 5;
    }
}

public class LoanEligibilitySystem {
    public static void main(String[] args) {
        Loan[] loans = {
            new HomeLoan("Krish", 54000, 600000),
            new CarLoan("Meet", 70000, 180000),
            new EducationLoan("Raman", 1500, 60000)
        };

        for (Loan loan : loans) {
            System.out.println(loan + " -> Eligible: " + loan.isEligible());
        }
    }
}
