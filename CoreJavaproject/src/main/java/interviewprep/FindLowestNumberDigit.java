package interviewprep;

public class FindLowestNumberDigit {
    public static void main(String[] args) {
        int number =139;
        int digit = 9;
        char c = Integer.toString(digit).charAt(0);
        while(true){
            number --;
            if(Integer.toString(number).indexOf(c) == -1){
                System.out.println(number);
                break;
            }
        }
    }
}
