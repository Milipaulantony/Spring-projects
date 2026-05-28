package interviewprep;

import java.util.*;

public class CountChars {
    public static void main(String[] args) {
        String input = "";
        input = new Scanner(System.in).nextLine();
        String input_mod = input.replaceAll("\\s","");
        System.out.println(input_mod);
        char[] input_array = input_mod.toCharArray();
        Map<Character, Integer> count_map = new HashMap<>();
        for(int i =0; i<input_array.length; i++){
            count_map.putIfAbsent(input_array[i], 0);
            count_map.put(input_array[i], (count_map.get(input_array[i])) + 1);
        }
        System.out.println(count_map);
    }
}
