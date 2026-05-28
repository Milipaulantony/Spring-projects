package interviewprep;

import java.util.*;

public class Duplicates_2 {
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
        Set<Map.Entry<Integer,Integer>> entrySet = count_check.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet){
            if(entry.getValue() > 1){
                System.out.println("The number "+ entry.getKey() + " has duplicates " +
                        "and count is =" + String.valueOf(entry.getValue()));
            }
        }
    }

}
