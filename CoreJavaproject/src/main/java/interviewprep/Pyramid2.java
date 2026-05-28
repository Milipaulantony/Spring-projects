package interviewprep;

import java.util.Scanner;

public class Pyramid2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want to enter");
        int no_of_Rows = sc.nextInt();
        int rowCount = 1;
        System.out.println("Here Is Your Pyramid");
        for (int i = no_of_Rows; i > 0; i--)
        {
            //Printing i spaces at the beginning of each row

            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++)
            {
                System.out.print(rowCount+" ");
            }
            System.out.println();

            //Incrementing the rowCount

            rowCount++;
        }
    sc.close();
    }
}
