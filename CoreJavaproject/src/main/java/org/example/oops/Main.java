package org.example.oops;

import org.example.CollectionEg.IteratorEg;
import org.example.CollectionEg.Listeg;
import org.example.CollectionEg.Mapeg;
import org.example.NewFeatures.concurrentHMEg;
import org.example.ThreadEgs.MyThread;
import org.example.ThreadEgs.MyThreadRunnable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        char name = 'x';
        char name2= 'x';
        String s = "Hello";
        System.out.println("the string" + s + "after concat" + s.concat("world")
                            + "the whole string " + s);

        StringBuilder sb = new StringBuilder("JAva");
        sb.append("World");
        System.out.println("Print " +sb);

        String a = "Java";
        String b = "World";
        if (a.equals(b))
            System.out.println("a and b are equal");
        for (int i = 1; i <= 5; i++) {
             System.out.println("i = " + i);
        }
        if(name == name2){
            System.out.println("THis is equal");
        }

        Person p1 = new Person(1,"Amy");
        Person p2 = new Person(1, "Amy");

        if (p1.equals(p2)){
            System.out.println("Equal");
        }

        if(p1.hashCode() == p2.hashCode()){
            System.out.println("Equal");
        }
        Animal d = new Dog();
        d.sound();

        Listeg listoper = new Listeg();
        listoper.listoperations();

        Mapeg m = new Mapeg();
        m.mapOperation();
        m.multiple_oper();
        m.multiple_oper_2();
        m.multiple_oper_3();
        m.multiple_oper_4();
        m.multiple_oper_5();
        m.collision_eg();

        IteratorEg iterator1= new IteratorEg();
        iterator1.iter_oper();
        iterator1.iter_oper_2();

        concurrentHMEg concurEg = new concurrentHMEg();
        concurEg.concurrentExecution();

        MyThread t_eg = new MyThread();
        t_eg.start();
        System.out.println("The thread name in main the first one is " + Thread.currentThread().getName());


        Thread t = new Thread(new MyThreadRunnable());
        t.start();
        System.out.println("The thread name in main after runnable clause is " + Thread.currentThread().getName());
    }
}