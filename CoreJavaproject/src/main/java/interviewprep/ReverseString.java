package interviewprep;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        //String final_result = obj.reversestring("Women");
        //String final_result = obj.reversestring_1("MyJava");
        //String final_result = obj.reversestring_2("Hitler");
        String final_result = obj.reversestring_3("Recursive");
        System.out.println(final_result);
    }

    //My code
    private String reversestring(String input) {
        String output = "";
        int start_index;
        for(start_index= (input.length() - 1);  start_index >= 0; start_index--){
            System.out.println(start_index);
            output += input.charAt(start_index);
            System.out.println(output);
        }
        return output;
    }

    //online codes
    private String reversestring_1(String input) {
        StringBuffer output = new StringBuffer(input);
        return output.reverse().toString();
    }

    private String reversestring_2(String input) {
        char[] input_array = input.toCharArray();
        String output="";
        for (int i = input_array.length - 1; i>=0; i--){
            output += input_array[i];
        }
        return output;
     }

    private String reversestring_3(String input) {
        if(input == null || input.length() <=1){
            return input;
        }
        return reversestring_3(input.substring(1)) + input.charAt(0);
    }
}
