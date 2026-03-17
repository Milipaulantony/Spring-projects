package org.example.NewFeatures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorEg {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            System.out.println("Task executed");
        });

        executor.shutdown();
    }

}
