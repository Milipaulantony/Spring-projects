package org.example.NewFeatures;

import java.util.concurrent.*;

class CallableTask implements Callable<Integer> {
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 5; i++) sum += i;
        return sum;
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> result = executor.submit(new CallableTask());
        System.out.println("Sum: " + result.get()); // Retrieves result
        executor.shutdown();
    }
}
