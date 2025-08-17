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
        BankAccount[] accounts = {
            new SavingsAccount(35778, "Kishan Singh", 5000),
            new CurrentAccount(10010, "Amit Verma", 2000),
            new SavingsAccount(12345, "Priya Mehta", 800),
            new CurrentAccount(54321, "Ravi Sharma", 100)
        };

        for (BankAccount account : accounts) {
            System.out.println(account);
            System.out.println("-----------------------------------------------------------");
        }

        
    }
}