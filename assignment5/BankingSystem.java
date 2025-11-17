class BankAccount {
    private int balance;

    public BankAccount (int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + amount);
            this.balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + ", balance : " + balance);
        } else {
            System.out.println("Insufficient funds for " + Thread.currentThread().getName());
        }
    }
}

class WithdrawTask implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawTask (BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000);
        WithdrawTask task1 = new WithdrawTask(ba, 5000);
        WithdrawTask task2 = new WithdrawTask(ba, 3000);
        WithdrawTask task3 = new WithdrawTask(ba, 3000);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}
