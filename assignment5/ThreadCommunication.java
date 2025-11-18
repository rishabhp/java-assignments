class Numbers {
    public synchronized void countNumber() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

            if (i == 5) {
                notify();

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }
    }

    public synchronized void halfwayMessage() {
        try {
            wait();
            System.out.println("Halfway There");
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class CountingNumber extends Thread {
    private Numbers numbersClass;

    public CountingNumber(Numbers numbersClass) {
        this.numbersClass = numbersClass;
    }

    @Override
    public void run() {
        numbersClass.countNumber();
    }
}

class HalfayMessage extends Thread {
    private Numbers numbersClass;

    public HalfayMessage(Numbers numbersClass) {
        this.numbersClass = numbersClass;
    }

    @Override
    public void run() {
        numbersClass.halfwayMessage();
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        CountingNumber cn = new CountingNumber(numbers);
        HalfayMessage hm = new HalfayMessage(numbers);

        hm.start();

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cn.start();
    }
}
