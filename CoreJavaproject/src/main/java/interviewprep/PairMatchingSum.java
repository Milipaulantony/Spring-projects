package interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PairMatchingSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 7, 11, 9, 13, 8, 12);

        int input = 20;
        for(int i=0; i< numbers.size(); i++){
            int operand1 = numbers.get(i);
            for(int j=i+1 ; j< numbers.size(); j++){
                int sum = operand1 + numbers.get(j);
                if (sum == input){
                    System.out.println("("+operand1+","+numbers.get(j)+")");
                }
            }
        }
    }
}
