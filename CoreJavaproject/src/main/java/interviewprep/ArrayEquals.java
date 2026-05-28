package interviewprep;

import java.lang.reflect.Array;

public class ArrayEquals {
    public static void main(String[] args) {
        Integer[] a1 = {2,3,4,5,6,7};
        Integer[] a2 = {2,3,4,5,6,7};

        if(a1.length == a2.length){
            for(int i=0; i<a1.length;i++){
                if (a1[i] != a2[i]){
                    System.out.println("Arrays  are different");
                    break;
                }
            }
        }

    }
}
