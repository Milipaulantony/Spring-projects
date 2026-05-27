package interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPIeg {
    public static void main(String[] args) {
        List<String> input = List.of("Jack Black","Wonder Woman", "Winner of Interview");
        String result = input.stream()
                .flatMap(s-> Arrays.stream(s.split(" ")))
                .map(String::toUpperCase)
                .reduce("",(a,b) -> a + " " +b)
                .trim();
        System.out.println(result);
    }
}
