package interviewprep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        List<Integer> input_1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> input_2 = Arrays.asList(11,12,13,14,10,16,7,18,9,100);
        List<Integer> combined = Stream.concat(input_1.stream(),input_2.stream())
                .sorted()
                .collect(Collectors.toList());
        Map<Integer, Long> intersection = combined.stream()
                .collect(Collectors.groupingBy(i -> i,
                                               Collectors.counting()));
        List<Integer> common_values = intersection.entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println(common_values);

    }
}
