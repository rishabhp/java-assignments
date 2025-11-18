import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskNum = i;
            executorService.submit(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " - Task: " + taskNum);
            });
        }

        executorService.shutdown();
    }
}
