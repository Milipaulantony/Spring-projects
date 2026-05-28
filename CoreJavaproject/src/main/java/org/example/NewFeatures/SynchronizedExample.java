package org.example.NewFeatures;

public class SynchronizedExample {
    // Shared resource
    static class Counter {
        private int count = 0;

        // Synchronized method to ensure only one thread updates at a time
        public synchronized void increment() {
            System.out.println("Thread updating here is " + Thread.currentThread().getName());
            count++;
        }

        public synchronized int getCount() {
            System.out.println("Thread getting count is " + Thread.currentThread().getName());
            return count;
        }
    }

    // Worker thread
    static class CounterThread extends Thread {
        private final Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create multiple threads sharing the same counter
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        // Display final count
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}

