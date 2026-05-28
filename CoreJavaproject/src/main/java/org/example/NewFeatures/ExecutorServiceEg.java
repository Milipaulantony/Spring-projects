package org.example.NewFeatures;

import java.util.concurrent.*;

public class ExecutorServiceEg {

    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // Submit Runnable tasks (no return value)
            executor.execute(() -> {
                System.out.println("Runnable Task 1 executed by " + Thread.currentThread().getName());
            });

            executor.execute(() -> {
                System.out.println("Runnable Task 2 executed by " + Thread.currentThread().getName());
            });

            // Submit Callable task (returns a value)
            Callable<String> callableTask = () -> {
                Thread.sleep(1000); // Simulate work
                return "Callable Task executed by " + Thread.currentThread().getName();
            };

            Future<String> futureResult = executor.submit(callableTask);

            // Retrieve result from Callable
            try {
                String result = futureResult.get(); // Blocks until result is available
                System.out.println("Result from Callable: " + result);
            } catch (ExecutionException e) {
                System.err.println("Task threw an exception: " + e.getCause());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                System.err.println("Task was interrupted.");
            }

        } finally {
            // Properly shut down the executor
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow(); // Force shutdown if tasks didn't finish
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
