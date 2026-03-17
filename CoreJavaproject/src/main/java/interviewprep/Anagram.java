package interviewprep;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        //List<String> input_1 = new ArrayList<>();
        //List<String> input_2 = new ArrayList<>();
        String input_1 = "";
        String input_2 = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("enter first string");
        input_1 = sc.nextLine().trim();
        System.out.println("enter second string");
        input_2 = sc.nextLine().trim();
        char[] a1 = input_1.toCharArray();
        char[] a2 = input_2.toCharArray();

        if (a1.length == a2.length) {
            Arrays.sort(a1);
            Arrays.sort(a2);
            System.out.println(a1);
            System.out.println(a2);
                if (Arrays.equals(a1,a2)) {
                    System.out.println("they are anagrams");
                } else {
                    System.out.println("Both are not equal");
                }

        }
    }
}
