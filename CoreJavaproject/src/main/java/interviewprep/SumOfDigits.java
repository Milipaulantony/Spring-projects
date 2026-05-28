package interviewprep;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Integer number = new Scanner(System.in).nextInt();
        int sum = 0;
        int copy_number = number;
        for(int i=0; i<String.valueOf(number).length() ; i++){
            int digit = copy_number% 10;
            sum +=digit;
            copy_number /= 10;
        }
        System.out.println("length of number is " + String.valueOf(number).length());
        System.out.println("sum is " + sum);

    }
}
