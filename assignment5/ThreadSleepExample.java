class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Thread-1 has finished execution");
    }
}
