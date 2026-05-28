package interviewprep;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int orig_number = sc.nextInt();
        int number = orig_number;
        int sum = 0;
        int total_digit = String.valueOf(number).length();
        for(int i=0; i< total_digit; i++){
            int digit = number % 10;
            //int digit =(int)number.charAt(i);
            int lastDigitToThePowerOfNoOfDigits = 1;
            System.out.println("digit is " + digit);
            for(int j = 0; j < total_digit; j++)
            {
                lastDigitToThePowerOfNoOfDigits = lastDigitToThePowerOfNoOfDigits * digit;
            }
            sum += lastDigitToThePowerOfNoOfDigits;

            number = number / 10;
        }

        System.out.println(sum);
        if(sum == orig_number)            System.out.println("anagram");
        else System.out.println("Not anagram");

    }
}
