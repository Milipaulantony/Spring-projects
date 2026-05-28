package org.example.NewFeatures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample2 {
    public static void main(String[] args) {
        // Run an asynchronous task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate long task
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello from CompletableFuture!";
        });

        // Transform the result
        CompletableFuture<String> transformedFuture = future.thenApply(result -> result + " Processed!");

        // Handle exceptions
        CompletableFuture<String> safeFuture = transformedFuture.exceptionally(ex -> "Error: " + ex.getMessage());

        try {
            // Blocking call to get the result
            String finalResult = safeFuture.get();
            System.out.println(finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
