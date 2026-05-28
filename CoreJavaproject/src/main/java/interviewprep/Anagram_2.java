package interviewprep;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram_2 {
    public static void main(String[] args) {

        String input_1 = "";
        String input_2 = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("enter first string");
        input_1 = sc.nextLine().trim();
        System.out.println("enter second string");
        input_2 = sc.nextLine().trim();

        String copy_of_input1 = input_1.replaceAll("\\s","");
        String copy_of_input2 = input_2.replaceAll("\\s","");
        System.out.println(copy_of_input1 + "\n" + copy_of_input2);
         boolean equal_status = true;
         if (copy_of_input1.length() != copy_of_input2.length()){
             equal_status = false;
         }
         else{
             char[] s1Array = copy_of_input1.toLowerCase().toCharArray();
             char[] s2Array = copy_of_input2.toLowerCase().toCharArray();
             Arrays.sort(s1Array);
             Arrays.sort(s2Array);
             System.out.println(s1Array + "\n" + s2Array);
             equal_status = Arrays.equals(s1Array, s2Array);
         }
         if(equal_status){
             System.out.println("Anagram");
         }else{
             System.out.println("NotAnagrams");
         }
    }
}
