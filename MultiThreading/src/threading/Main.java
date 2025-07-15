package threading;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong num = new AtomicLong(0); // Shared and thread-safe

        Thread myThread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                num.incrementAndGet(); // atomically increments by 1
            }
            System.out.println("myThread1 ended");
        });

        Thread myThread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                num.incrementAndGet();
            }
            System.out.println("myThread2 ended");
        });

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println("Final value of num: " + num.get());
    }
}
