package interviewprep;

import java.util.*;

public class ArrayEquals3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        System.out.println("enter numbers for array 1");

        while (true) {
            try {


                String input_string = "";
                input_string = sc.next();
                if (input_string.equalsIgnoreCase("done")) {
                    break;
                } else {
                    a1.add(Integer.valueOf(input_string));
                }
            }catch(NumberFormatException num_err){
                System.out.println("Please enter number");
            }
        }

        System.out.println("enter numbers for array 2");

        while (true) {
            String input_string = "";
            input_string = sc.next();
            if (input_string.equalsIgnoreCase("done")) {
                break;
            } else {
                a2.add(Integer.valueOf(input_string));
            }
        }

        if (a1.size() == a2.size()) {
            if (a1.equals(a2)) {
                System.out.println("Both are equal");
            } else {
                Collections.sort(a1);
                Collections.sort(a2);
                if (a1.equals(a2)) {
                    System.out.println("Both are equal, but in different order");
                } else {
                    System.out.println("Both are not equal");
                }
            }
        }
        System.out.println("the array a1 is " + a1);
        System.out.println("the array a2 is " + a2);


    }
}
