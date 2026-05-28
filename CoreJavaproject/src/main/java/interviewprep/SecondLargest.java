package interviewprep;

import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        int i=0;
        while(i< 10){
            a1.add(new Scanner(System.in).nextInt());
            i++;
        }
        Collections.sort(a1);
        System.out.println("The second largest is " + a1.get(a1.size() - 2 ));


    }
}
