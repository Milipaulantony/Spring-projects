package interviewprep;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("file.txt"); // May throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
