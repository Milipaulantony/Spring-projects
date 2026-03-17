package interviewprep;

public class Pyramid {
    public static void main(String[] args) {
        Pyramid obj = new Pyramid();
        //obj.buildPyramid(21);
        obj.buildPyramid_1(9);
    }

    //My code
    private void buildPyramid(int n) {
        int total_rows = (n/5) + 2;
        System.out.println(total_rows);
        int count = 1;
            for(int i=1; i <=total_rows ; i++)
            {

                String row_no="";
                int j=1;
                while(count <= n && j<=i) {

                        //System.out.println("Inside i" + i);
                        row_no += count;
                        row_no += " ";
                        count += 1;
                        j+=1;

                }
                System.out.println(row_no+"\n");
            }
        }


    private void buildPyramid_1(int n) {
        int space_count = n;
        for(int i=1; i <=n ; i++)
        {

            String row_no="";
            for(int j=1; j<=i;j++){
                row_no += j;
                row_no += " ";
            }
            String blank_space="";
            for(int x=1;x<=space_count;x++){
                blank_space +=" ";
            }
            System.out.println(blank_space + row_no+"\n");
            space_count -=1;
        }
    }
}

