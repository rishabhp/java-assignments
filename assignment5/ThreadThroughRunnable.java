class EvenNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
            }
        }
    }
}

class OddNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i);
            }
        }
    }
}

public class ThreadThroughRunnable {
    public static void main(String[] args) {
        OddNumbers oddNumbers = new OddNumbers();
        EvenNumbers evenNumbers = new EvenNumbers();

        Thread t1 = new Thread(oddNumbers);
        Thread t2 = new Thread(evenNumbers);

        t1.start();
        t2.start();
    }
}
