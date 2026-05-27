package interviewprepcomplex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EDIInputStream {
    public static void main(String[] args)  {

        ByteArrayInputStream stream = new ByteArrayInputStream((""
                + "ISA*00*          *00*          *ZZ*ReceiverID     *ZZ*Sender         *200711*0100*^*00501*000000001*0*T*:~"
                + "GS*HC*99999999999*888888888888*20111219*1340*1*X*005010X222~"
                + "ST*837*0001*005010X222~"
                + "BHT*0019*00*565743*20110523*154959*CH~"
                + "NM1*41*2*SAMPLE INC*****46*496103~"
                + "PER*IC*EDI DEPT*EM*FEEDBACK@example.com*TE*3305551212~"
                + "NM1*40*2*PPO BLUE*****46*54771~"
                + "HL*1**20*1~"
                + "SE*7*0001~"
                + "GE*1*1~"
                + "IEA*1*000000001~").getBytes());
        InputStreamReader  reader =new InputStreamReader(stream);
        //System.out.println(reader.read());
        try {
            int byteData;
            while ((byteData = reader.read()) != -1) {
                // Convert byte to char for display
                System.out.print((char) byteData);
                System.out.print("\n");
            }
        }
        catch(IOException i){
            System.out.println("Error while reading");
        }
    }
}
