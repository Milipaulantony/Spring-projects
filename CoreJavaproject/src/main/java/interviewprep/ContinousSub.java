package interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinousSub {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 5, 31, 9, 21, 15);
        int input = 45;
        List<Integer> sub_list = new ArrayList<>();

        for(int i =0; i< numbers.size(); i++){
            sub_list.clear();
            int sum = numbers.get(i);
            sub_list.add(numbers.get(i));
            for(int j=i+1; j<numbers.size(); j++) {
                System.out.println("Inside j loop");
                sum += numbers.get(j);
                sub_list.add(numbers.get(j));
                if (sum == input) {
                    System.out.println(sub_list);
                    sub_list.clear();
                    System.out.println("After breaking");
                    break;

                }
                System.out.println("j value"+ j);

            }
        }
    }
}
