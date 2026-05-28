package interviewprep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("C:\\Users\\milip\\OneDrive\\Desktop\\Testfiles\\ScannerCheck1.txt");
        String file_line="";
        int i=0;
        try(Scanner sc = new Scanner(f1)){
            sc.useDelimiter("\n");
            while(sc.hasNext())
            {
                file_line = sc.next();
                System.out.println(i++ + ": " + file_line);
            }
        }catch(IOException e){
            //e.printStackTrace();
            System.out.println("The error occured here is " + e);
        }
        //Even after exception program runs
        System.out.println("the program ends here");


    }
}
