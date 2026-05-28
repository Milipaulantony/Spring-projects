package interviewprep;

import java.util.function.Supplier;

public class SupplierEg {
    static String heavyComputation() {
        System.out.println("Computing...");
        return "Result";
    }

    public static void main(String[] args) {
        Supplier<String> lazy = () -> heavyComputation();

        System.out.println("Before get()");
        String value = lazy.get();
        System.out.println("After get(): " + value);
    }
}
