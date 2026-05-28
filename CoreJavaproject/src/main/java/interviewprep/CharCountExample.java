package interviewprep;

import java.util.*;
import java.util.stream.Collectors;

public class CharCountExample {

    public static void main(String[] args) {

        String input = "Java J2EE Java JSP J2EE";

        Map<Character, Long> charCount =
                input.chars()                       // IntStream of characters
                        .mapToObj(c -> (char) c)       // convert int → Character
                        .collect(Collectors.groupingBy(
                                c -> c,               // group by character
                                Collectors.counting() // count occurrences
                        ));

        charCount.forEach((key, value) ->
                System.out.println(key + " = " + value));
    }
}

