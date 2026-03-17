package org.example.CollectionEg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorEg {
    List<Integer> list_eg = new ArrayList<>();

    public void iter_oper(){
        for(int i=1;  i<=10; i++)
            list_eg.add(i);
        Iterator<Integer> iter_eg = list_eg.iterator();
        while(iter_eg.hasNext()){
            Integer value = iter_eg.next();
            if ( value == 7) {
                System.out.println("In loop");
                iter_eg.remove();
            }
            System.out.println(value);
        }
    }


    public void iter_oper_2(){
        for(int i=1;  i<=10; i++)
            list_eg.add(i);
        ListIterator<Integer> iter_eg_2 = list_eg.listIterator();
        while(iter_eg_2.hasNext()){
            Integer value = iter_eg_2.next();
            if ( value == 7) {
                      //set replaces the value and add the new value after the current one
                      //both cannot be used together
                     //iter_eg_2.add(100);
                     iter_eg_2.set(300);
            }

        }
        System.out.println(list_eg);
    }

}
