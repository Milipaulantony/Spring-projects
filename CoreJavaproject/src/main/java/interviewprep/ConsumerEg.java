package interviewprep;

import java.util.function.Consumer;

public class ConsumerEg {
    public static void main(String[] args) {
        Consumer<String> print    = s -> System.out.println("Value: " + s);
        Consumer<String> printLen = s -> System.out.println("Length: " + s.length());

        Consumer<String> both = print.andThen(printLen);
        both.accept("Hello");
    }
}
