import java.util.Scanner;

class InvalidDeposit extends Exception {
    public InvalidDeposit(String message) {
        super(message);
    } 
}

class InvalidWithdraw extends Exception {
    public InvalidWithdraw(String message) {
        super(message);
    } 
}

public class BankAccount {
    
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void depositAmount(double depositAmount) throws InvalidDeposit {
        if (depositAmount < 0) {
            throw new InvalidDeposit("Deposit amount cannot be negative");
        }

        this.balance += depositAmount;
    }

    public void withdrawAmount(double withdrawAmount) throws InvalidWithdraw {
        if (withdrawAmount < 0) {
            throw new InvalidWithdraw("Withdrawn amount cannot be negative");
        }
        
        if (this.balance < withdrawAmount) {
            throw new InvalidWithdraw("Not enough balance in the account");
        }

        this.balance -= withdrawAmount;
    }

    public void showBalance() {
        System.out.println("Current Balance: " + this.balance);
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(0);

        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("1. Deposit\n2. Withdraw\n3. Show Balance\n4. Exit\nChoose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to deposit");
                    int depositAmount = scanner.nextInt();

                    try {
                        bankAccount.depositAmount(depositAmount);   
                    } catch (InvalidDeposit e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter the amount to withdraw");
                    int withdrawAmount = scanner.nextInt();

                    try {
                        bankAccount.withdrawAmount(withdrawAmount);   
                    } catch (InvalidWithdraw e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    bankAccount.showBalance();
                    break;

                case 4:
                    continueLoop = false;
                    break;
                    
                default:
                    System.out.println("Invalid Option!");
            }
        }
        scanner.close();
    }
}
