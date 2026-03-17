package org.example.ThreadEgs;

public class MyThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside run method of runnable class");
        System.out.println("The thread name in runnable is " + Thread.currentThread().getName());
    }
}
