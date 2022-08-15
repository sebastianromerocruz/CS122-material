package multithreading;

import java.util.Random;

public class Counter extends Thread {
    private static final int WAITING_TIME_LIMIT = 1000;

    private final String name;

    public static void main(String[] args) {
        Random randomNumberGenerator = new Random();
        int randomNumber = randomNumberGenerator.nextInt(10000);

        Counter chisato = new Counter("Chisato");
        Counter takina = new Counter("Takina");

        // Notice that we've switched from countToTen() to start()
        chisato.start();
        takina.start();
    }

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.countToTen();
    }

    private void countToTen() {
        Random waiter = new Random();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.printf("%s: %d...%n", this.name, i + 1);
                Thread.sleep(waiter.nextInt(WAITING_TIME_LIMIT));
            } catch (InterruptedException e) {
                System.out.printf("%s was interrupted.%n", this.name);
            }
        }
    }
}
