package org.example.NewFeatures;

public class VolatileSynchronizedExample {

    // Volatile ensures visibility of changes across threads
    private volatile boolean running = true;

    // Shared counter that needs atomic updates
    private int counter = 0;

    // Synchronized method ensures atomic increment
    public synchronized void incrementCounter() {
        counter++;
    }

    public void startWorkers() {
        // Create two worker threads
        Thread worker1 = new Thread(this::doWork, "Worker-1");
        Thread worker2 = new Thread(this::doWork, "Worker-2");

        worker1.start();
        worker2.start();

        try {
            // Let them run for 2 seconds
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop workers by changing the volatile flag
        running = false;

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + counter);
    }

    private void doWork() {
        while (running) {
            incrementCounter(); // Thread-safe increment
            try {
                Thread.sleep(10); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }

    public static void main(String[] args) {
        new VolatileSynchronizedExample().startWorkers();
    }
}

