package interviewprep;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiEgs {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Amanda", "Brian", "Charlie");

        List<String> result = names.stream()
                .filter(n -> n.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result); // ?

        List<String> words = List.of("banana", "kiwi", "apple", "fig", "mango");

        List<String> result_2 = words.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(result_2); // ?

        List<List<Integer>> nested = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        List<Integer> result_3 = nested.stream()
                .flatMap(Collection::stream)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(result_3); // ?

        List<String> words_1 = List.of("ant", "bear", "cat", "ape", "bison", "crow");

        Map<Character, List<String>> grouped = words_1.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));

        grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

        List<String> sentences = List.of("java is fun", "streams are powerful");

        Map<Integer, List<String>> byLength = Arrays.stream(
                        sentences.stream()
                                .collect(Collectors.joining(" "))
                                .split(" ")
                )
                .collect(Collectors.groupingBy(String::length));

        byLength.forEach((k, v) -> System.out.println(k + " -> " + v));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumA = numbers.stream()
                .reduce(0, Integer::sum);

        int sumB = numbers.parallelStream()
                .reduce(0, Integer::sum);

        List<Integer> listC = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(sumA);  // ?
        System.out.println(sumB);  // ?
        System.out.println(listC); // ?
    }
}
