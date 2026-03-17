package org.example.NewFeatures;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class concurrentHMEg {

    // Create a ConcurrentHashMap
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    // Thread pool with 3 threads
    ExecutorService executor = Executors.newFixedThreadPool(3);

            // Task 1: Insert elements

        Runnable writerTask = () -> {
            for (int i = 1; i <= 5; i++) {
                String key = "Key" + i;
                map.put(key, i);
                System.out.println(Thread.currentThread().getName() + " inserted: " + key + " -> " + i);
                try {
                    Thread.sleep(50); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


        // Task 2: Read elements
        Runnable readerTask = () -> {
            for (int i = 1; i <= 5; i++) {
                String key = "Key" + i;
                Integer value = map.get(key);
                System.out.println(Thread.currentThread().getName() + " read: " + key + " -> " + value);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };



        // Task 3: Remove elements
        Runnable removerTask = () -> {
            for (int i = 1; i <= 5; i++) {
                String key = "Key" + i;
                Integer removed = map.remove(key);
                System.out.println(Thread.currentThread().getName() + " removed: " + key + " -> " + removed);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };


    public void concurrentExecution(){
            // Execute tasks concurrently
            executor.execute(writerTask);
            executor.execute(readerTask);
            executor.execute(removerTask);

            // Shutdown executor
            executor.shutdown();
        }
}



