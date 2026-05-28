package interviewprep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Duplicates {
    public static void main(String[] args) {

        int[] numbers = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("give 10 numbers");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }
        Map<Integer, Integer> count_check = new HashMap<>();
        for(int i=0; i<10;i++){
            count_check.putIfAbsent(numbers[i],0);
            count_check.put(numbers[i], count_check.get(numbers[i]) + 1);

        }
        for(Integer key:count_check.keySet()){
            if(count_check.get(key) > 1){
                System.out.println("The number "+ key + " has duplicates " +
                        "and count is =" + String.valueOf(count_check.get(key)));
            }
        }
    }

}
