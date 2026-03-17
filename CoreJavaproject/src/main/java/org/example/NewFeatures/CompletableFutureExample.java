package org.example.NewFeatures;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // simulate delay
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 42;
        });

        future.thenAccept(result ->
                System.out.println("Result: " + result)
        );



        System.out.println("Doing other work...");

        //for trying out to get the result value
        // future.join();
    }
}
