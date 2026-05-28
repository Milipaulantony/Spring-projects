package org.example.CollectionEg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Listeg {
    private List<Integer> integerList = new ArrayList<>();
    private List<Integer> integerList2 = new LinkedList<>();
    List<Integer> arrayList = new ArrayList<Integer>();
    List<Integer> linkList = new LinkedList<Integer>();


    public void updateArray(){
        integerList.add(1);
        integerList.add(2);

    }

    public void updateLinked(){
        integerList2.add(1000);
        integerList2.add(2000);
        integerList2.add(3000);
    }

    public void listoperations(){
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        linkList.add(2,32);
        arrayList.add(5,1000);
        for(int i:linkList)
            System.out.println(i);
        for(int i:arrayList)
            System.out.println(i);
    }
    public void listcomparisons(){
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        long start = 0;
        long end = 0;
        Random random = new Random();

        /*
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkList.add(random.nextInt(100000), 7);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList add ,random index" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextInt(100000), 7);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList add ,random index" + (end - start));
        */
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkList.add(0, 7);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList add ,index == 0" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, 7);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList add ,index == 0" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList add ,index == size-1" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList add ,index == size-1" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkList.remove(Integer.valueOf(random.nextInt(100000)));
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList remove ,random index" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(Integer.valueOf(random.nextInt(100000)));
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList remove ,random index" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList remove ,index == 0" + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList remove ,index == 0" + (end - start));



    }

}
