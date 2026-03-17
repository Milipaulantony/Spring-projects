package interviewprep;

public class BinaryOrNot {
    public static void main(String[] args) {
        int number = 101101;
        //int number =2134;
        boolean status=true;
        for(int i=2;i<=9;i++){
            //toString returns string so to get char value we are outting charAt0
            char c = Integer.toString(i).charAt(0);
            int index_no= Integer.toString(number).indexOf(c);
            if ( index_no > -1){
                status = false;
                break;
            }
        }
        if(status){
            System.out.println("Its boolean");
        }
    }
}
