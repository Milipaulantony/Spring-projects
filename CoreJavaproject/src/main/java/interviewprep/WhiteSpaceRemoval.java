package interviewprep;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhiteSpaceRemoval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string that has the whitespace to be removed");
        String input_string = sc.nextLine();
        //String input_string = "The      previos    program has     2 spaces    at \tthe \tend.";
        String replaced_string = input_string.replaceAll("\\s+","");
        System.out.println(replaced_string);
        String outputstring = "";
        for(int i = 0; i< input_string.length(); i++)
        {
            char letter = input_string.charAt(i);
            if( letter != '\s'){
               outputstring += letter;
            }

        }
        System.out.println(outputstring);
    }
}
