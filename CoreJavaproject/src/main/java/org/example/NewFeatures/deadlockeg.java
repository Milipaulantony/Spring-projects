package org.example.NewFeatures;

public class deadlockeg {

    // Two resources (locks)
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        // Thread 1 tries to lock LOCK1 then LOCK2
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Thread 1: Locked LOCK1");

                // Simulate some work
                try { Thread.sleep(100); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread 1: Waiting for LOCK2...");
                synchronized (LOCK2) {
                    System.out.println("Thread 1: Locked LOCK2");
                }
            }
        });

        // Thread 2 tries to lock LOCK2 then LOCK1
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("Thread 2: Locked LOCK2");

                // Simulate some work
                try { Thread.sleep(100); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread 2: Waiting for LOCK1...");
                synchronized (LOCK1) {
                    System.out.println("Thread 2: Locked LOCK1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
