abstract class BankAccount {
    protected long accountNumber;
    protected String accountHolderName;
    protected int balance;

    public BankAccount(long accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    abstract public void deposit(int amount);
    abstract public void withdraw(int amount);

    @Override
    public String toString() {
        return "Account Number: " + this.accountNumber + 
                "\nAccount Holder Name: " + this.accountHolderName + 
                "\nBalance: " + this.balance;
    }
}

class SavingsAccount extends BankAccount {
    private static final int MIN_BALANCE = 500;
    public SavingsAccount(long accountNumber, String accountHolderName, int balance) {
        super(accountNumber, accountHolderName, balance);
        validateBalance();
    }

    private void validateBalance() {
        if (this.balance < MIN_BALANCE) {
            throw new ArithmeticException("Balance must be greater than or equal to " + MIN_BALANCE);
        } 
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new ArithmeticException("You must deposit a positive amount");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot withdraw negative amount!");
        }
        if (this.balance - amount < MIN_BALANCE) {
            throw new ArithmeticException("Withdrawal not allowed! Min Balance would be breached");
        }
        this.balance -= amount;
    }
}

class CurrentAccount extends BankAccount {
    private static final int MAX_OVERDRAFT = 1000;

    public CurrentAccount(long accountNumber, String accountHolderName, int balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new ArithmeticException("You must deposit a positive amount");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot withdraw negative amount!");
        }
        if (this.balance - amount < -MAX_OVERDRAFT) {
            throw new ArithmeticException("Withdrawal not allowed! Min Balance would be breached");
        }
        this.balance -= amount;
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(10010, "Kishan Singh", 500);
        BankAccount acc2 = new CurrentAccount(30276, "Kinjal Shah", 0);

        acc1.deposit(4500);
        acc2.deposit(1000);

        System.out.println("Account 1:-\n" + acc1 + "\n-------------------------------------------------------------------------------------------------");
        System.out.println("Account 2:-\n" + acc2 + "\n-------------------------------------------------------------------------------------------------");

        System.out.println("Withdrawing 1500 from current account (Overdraft of 1000 allowed)");
        acc2.withdraw(1500);
        System.out.println("Updated Account:-\n" + acc2 + "\n-------------------------------------------------------------------------------------------------");

        try {
            System.out.println("Withdrawing 4700 from savings account (Minimum Balance: 500)");
            acc1.withdraw(4700);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}