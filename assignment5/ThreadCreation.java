class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (char i = 'A'; i <= 'J'; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}
