package org.example.NewFeatures;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // simulate delay
            return 42;
        });

        System.out.println("Doing other work...");

        Integer result = future.get(); // blocks until result is available
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
