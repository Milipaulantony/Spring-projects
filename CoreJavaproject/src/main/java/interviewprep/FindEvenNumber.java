package interviewprep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindEvenNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,3,5,1,8,9,10,12,56,18,23,57,93,30);
        List<Integer> evens = numbers.stream()
                .filter((i) -> i%2 == 0 )
                .sorted()
                .collect(Collectors.toList());
        System.out.println(evens);
    }
}
