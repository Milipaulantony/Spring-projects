package interviewprep;

import java.util.Arrays;

public class ReverseString2 {
    public static void main(String[] args) {
        String input = "Java Concept Of The Day";
        String[] word_list = input.split(" ");
        String revers_input = "";
        for(int i=0;i<word_list.length;i++){
            String reverse_word ="";
            String word = word_list[i];
            System.out.println(word);
            for(int j=word.length() - 1; j >= 0 ;j--){

                reverse_word = reverse_word + word.charAt(j);

            }
            revers_input = revers_input + reverse_word + " ";
        }
        System.out.println(revers_input);
    }
}
