package org.example.ThreadEgs;

public class MyThread extends Thread {
    public void run(){
        System.out.println("The run method is running");
        System.out.println("The thread name in thread class is " + Thread.currentThread().getName());
    }
}
