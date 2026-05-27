package interviewprep;

import java.util.Optional;

public class OptionalEg {
    public static void main(String[] args) {
        Optional<String> opt = Optional.ofNullable(null);

        String val1 = opt.orElse(getDefault());      // always calls method
        String val2 = opt.orElseGet(() -> getDefault()); // lazy call

        System.out.println(val1);
        System.out.println(val2);
    }

    static String getDefault() {
        System.out.println("Generating default...");
        return "Default";
    }
}
