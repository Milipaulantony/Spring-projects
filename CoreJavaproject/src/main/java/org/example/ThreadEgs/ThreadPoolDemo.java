package org.example.ThreadEgs;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class ThreadPoolDemo {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void main(String[] args) {
        System.out.println("=== FixedThreadPool Demo ===");
        runFixedThreadPool();

        System.out.println("\n=== CachedThreadPool Demo ===");
        runCachedThreadPool();

        System.out.println("\n=== SingleThreadExecutor Demo ===");
        runSingleThreadExecutor();

        System.out.println("\n=== ScheduledThreadPool Demo ===");
        runScheduledThreadPool();
    }

    private static void runFixedThreadPool() {
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            fixedPool.submit(() -> log("FixedPool Task " + taskId));
        }
        shutdownAndAwait(fixedPool);
    }

    private static void runCachedThreadPool() {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            cachedPool.submit(() -> log("CachedPool Task " + taskId));
        }
        shutdownAndAwait(cachedPool);
    }

    private static void runSingleThreadExecutor() {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 4; i++) {
            final int taskId = i;
            singlePool.submit(() -> log("SingleThread Task " + taskId));
        }
        shutdownAndAwait(singlePool);
    }

    private static void runScheduledThreadPool() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // One-time delayed task
        scheduler.schedule(() -> log("Scheduled (delayed) task"), 2, TimeUnit.SECONDS);

        // Periodic task
        scheduler.scheduleAtFixedRate(() -> log("Scheduled (periodic) task"),
                1, 2, TimeUnit.SECONDS);

        // Let it run for 7 seconds so we can see multiple executions
        sleep(7000);

        shutdownAndAwait(scheduler);
    }

    private static void log(String message) {
        String time = LocalTime.now().format(TIME_FORMAT);
        System.out.println("[" + time + "] " + message + " executed by " + Thread.currentThread().getName());
        sleep(500); // Simulate work
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void shutdownAndAwait(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
