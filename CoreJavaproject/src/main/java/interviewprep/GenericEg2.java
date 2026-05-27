package interviewprep;

public class GenericEg2 {
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {


            Integer[] nums = {1, 2, 3};
            String[] names = {"A", "B", "C"};

            printArray(nums);
            printArray(names);
        }
    }

