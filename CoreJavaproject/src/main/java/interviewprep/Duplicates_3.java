package interviewprep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates_3 {
    public static void main(String[] args) {

        int[] numbers = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("give 10 numbers");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }
        Set<Integer> unique_list = new HashSet<>();
        Set<Integer> duplicate_list = Arrays.stream(numbers)
                                      .filter(i->!unique_list.add(i))
                                      .boxed()
                                      .collect(Collectors.toSet());
        System.out.println(duplicate_list);
    }
}
