package interviewprep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DuplicateChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> duplicate_map = new HashMap<>();
        String input_string = sc.next();
        for(int cindex=0; cindex < input_string.length(); cindex++){
            char letter = input_string.charAt(cindex);
            duplicate_map.putIfAbsent(letter,0);
            duplicate_map.put(letter,duplicate_map.get(letter) + 1);

        }
        Set<Character> charsInString = duplicate_map.keySet();
        for(char c:charsInString){
            if(duplicate_map.get(c) > 1){
                System.out.println("The letter "+ c + "has count =" + duplicate_map.get(c));
            }
        }
    }
}
