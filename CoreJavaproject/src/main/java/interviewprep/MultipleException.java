package interviewprep;

public class MultipleException {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General: " + e.getMessage());
        }
    }
}