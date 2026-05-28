package interviewprep;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            String result = "";
            if ( i % 3 == 0) result += "Fizz";
            if(i % 5 == 0) result += "Buzz";
            if(result.isEmpty()){
                result = String.valueOf(i);
            }
            output.add(result);

        }
        return output;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List final_result = sol.fizzBuzz(15);
        System.out.println(final_result);
    }
}
