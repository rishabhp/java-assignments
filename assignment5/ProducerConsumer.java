import java.util.*;
import java.util.LinkedList;

class SharedBuffer {
    private int MAX_SIZE;
    private Queue<Integer> buffer;

    public SharedBuffer (int size) {
        MAX_SIZE = size;
        buffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == MAX_SIZE) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is empty...");
            wait();
        }
        int item = buffer.remove();
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int item = 0;
            while (true) {
                buffer.produce(item);
                item++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);
        Producer producerTask = new Producer(sharedBuffer);
        Consumer consumerTask = new Consumer(sharedBuffer);

        Thread t1 = new Thread(producerTask);
        Thread t2 = new Thread(consumerTask);

        t1.start();
        t2.start();
    }
}
