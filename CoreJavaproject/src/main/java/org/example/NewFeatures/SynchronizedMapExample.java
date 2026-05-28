package org.example.NewFeatures;

import java.util.*;

public class SynchronizedMapExample {

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> map =
              Collections.synchronizedMap(new HashMap<>());


        Runnable task = () -> {
            for(int i = 0; i < 5; i++){
                map.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();

        //t1.join(); - below situation resolution either wait for the t1 to finish
        //t2.join(); below situation resolution either wait for the t1 to finish
        //Thread.currentThread().sleep(10);
        // Without this sleep statement what is happening is
        // Main thread starts t1
        //Main thread starts t2
        //Main thread immediately iterates map - putting lock on the entire map
        //Map is still empty
        //Threads insert values later  - so reading give empty result
        synchronized(map) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        //The synchronizedmap can throw concureentmodification exception because
        //here in iteration each method will have lock and it involves so many methods iterator,getkey,hasnextetc
        //so synchronized(map) will put lock on the entire thing, which programmer has to do external synchronization
        //concurrent hashmap was weeak iterators, so this process can be skipped




    }
}
