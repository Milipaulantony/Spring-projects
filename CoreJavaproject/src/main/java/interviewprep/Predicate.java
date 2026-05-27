package interviewprep;

public class Predicate {
    public static void main(String[] args) {
        java.util.function.Predicate<String> isLong = s -> s.length() > 5;
        java.util.function.Predicate<String> startsWithJ = s -> s.startsWith("J");

        java.util.function.Predicate<String> combined = isLong.and(startsWithJ);

        System.out.println(combined.test("Java"));       // ?
        System.out.println(combined.test("JavaScript")); // ?
        System.out.println(combined.test("Python"));     // ?

    }
}
