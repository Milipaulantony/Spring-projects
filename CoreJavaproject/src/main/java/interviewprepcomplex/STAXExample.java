package interviewprepcomplex;

import javax.xml.stream.*;
import java.io.FileInputStream;

public class STAXExample {
    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("C:\\Users\\milip\\OneDrive\\Desktop\\Testfiles\\employee.xml"));

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        String name = reader.getLocalName();
                        //System.out.println("the thing read is " + name);
                        if ("id".equals(name)) {
                            reader.next();
                            System.out.println("ID: " + reader.getText());
                        }
                        if(name.equals("name")){
                            reader.next();
                            System.out.println("Name: " + reader.getText());
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        // optional handling
                        String xyz = reader.getText();
                        System.out.println("xyz is " + xyz);
                        break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}