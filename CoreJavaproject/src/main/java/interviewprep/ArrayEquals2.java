package interviewprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayEquals2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] a1 = new Integer[10];
        Integer[] a2 = new Integer[10];
        System.out.println("enter 10 numbers for array 1");
        for(int i=0;i<10;i++){
            System.out.println("Enter number");
            a1[i]= sc.nextInt();
        }
        System.out.println("enter 10 numbers for array 2");
        for(int i=0;i<10;i++){
            System.out.println("Enter number");
            a2[i]= sc.nextInt();
        }
        boolean isequal_status= true;
        if(a1.length == a2.length){
            for(int i=0; i<a1.length;i++){
                if (a1[i] != a2[i]){
                    isequal_status = false;
                    break;
                }
            }
        }
        if(isequal_status){
            System.out.println("Arrays are same");
        }
    }
}
