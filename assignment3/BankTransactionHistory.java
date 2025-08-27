import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

enum TransactionType {
    WITHDRAW, DEPOSIT
}

class Transaction {
    private final TransactionType transactionType;
    private final double amount;
    private final Date date;

    public Transaction(TransactionType transactionType, double amount, Date date) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction Type: " + transactionType + "\nAmount of Transaction: " + amount + "\nDateTime of Transaction: " + date;
    }
}

class BankAccount {
    private String bankNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public BankAccount(String bankNumber, double balance) {
        this.bankNumber = bankNumber;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot deposit negative amount!");
        }
        this.balance += amount;
        Transaction transactionDetail = new Transaction(TransactionType.DEPOSIT, amount, new Date());
        transactions.add(transactionDetail);
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot withdraw negative amount!");
        }
        if (amount > this.balance) {
            throw new ArithmeticException("Not enough balance in the account!");
        }
        this.balance -= amount;
        Transaction transactionDetail = new Transaction(TransactionType.WITHDRAW, amount, new Date());
        transactions.add(transactionDetail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bank Number: ").append(bankNumber).append("\nAmount: ").append(balance)
            .append("\n----------------------------------------------------------------------------------------------------\n")
            .append("TRANSACTION HISTORY:-\n\n");

        for (Transaction transaction : transactions) {
            sb.append(transaction).append("\n\n");
        }
        return sb.toString();
    }
}

public class BankTransactionHistory {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("1B89ASD6TY", 10_000);
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) { 
            System.out.print("1. Deposit\n2. Withdraw\n3. Display\n4. Exit\nWhat operation do you want to perform: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("\nEnter the amount you want to deposit: ");
                    double amount = scanner.nextDouble();
                    ba.deposit(amount);
                    System.out.println("Deposited " + amount + " ruppess to your account successfully!");
                    break;
                }

                case 2: {
                    System.out.print("\nEnter the amount you want to withdraw: ");
                    double amount = scanner.nextDouble();
                    ba.withdraw(amount);
                    System.out.println("Withdrawn " + amount + " ruppess to your account successfully!");
                    break;
                }

                case 3: {
                    System.out.println("\nBank Account Details:-\n" + ba);
                    break;
                }

                case 4: {
                    continueLoop = false;
                    break;
                }

                default: {
                    System.out.println("Invalid option selected!");
                }
            }
        }

        scanner.close();
    }
}