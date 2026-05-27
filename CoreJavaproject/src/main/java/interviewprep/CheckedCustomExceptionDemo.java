package interviewprep;

// Custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CheckedCustomExceptionDemo {
    // Method that throws the custom checked exception
    public static void registerUser(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("User must be at least 18 years old.");
        }
        System.out.println("User registered successfully!");
    }

    public static void main(String[] args) {
        try {
            registerUser(16); // This will throw the exception
        } catch (InvalidAgeException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
    }
}

