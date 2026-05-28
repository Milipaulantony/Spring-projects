package interviewprep;

import java.util.Scanner;

public class IntegerOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try{
            Integer.parseInt(s);
            System.out.println("The entered string is a number");
        }catch(NumberFormatException n){
            System.out.println("The entered string is not a number");
        }

    }
}
