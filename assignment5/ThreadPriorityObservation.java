class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Thread with priority " + Thread.currentThread().getPriority() + ": " + i);
        }
    }
}

public class ThreadPriorityObservation {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
