package interviewprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Duplicates_4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,1,2,3,4,5,6,6,7,8,8,9,10,1,11);
        Map<Integer, Integer> duplicate_count= new HashMap<>();
        for(Integer i : numbers){
            duplicate_count.put(i, duplicate_count.getOrDefault(i,0) +1);
        }
        for(Integer key:duplicate_count.keySet()){
            if(duplicate_count.get(key) > 1){
                System.out.println("key is " + key + "and value is =" + duplicate_count.get(key));
            }
        }
        System.out.println(duplicate_count);
    }
}
