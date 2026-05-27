package interviewprepcomplex;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLProcessing {
    public static void main(String[] args) {
        // C:\Users\milip\OneDrive\Desktop\Testfiles
        try{
            File xmlFile = new File("C:\\Users\\milip\\OneDrive\\Desktop\\Testfiles\\employee.xml");
            File xsdFile = new File("C:\\Users\\milip\\OneDrive\\Desktop\\Testfiles\\employee.xsd");

            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(xsdFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            dbFactory.setSchema(schema);
            //dbFactory.setSchema(schema);
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("XML is valid");

            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String dept = element.getElementsByTagName("department").item(0).getTextContent();

                System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + dept);
            }

        }catch(Exception e){
            System.out.println("XML is NOT valid!");
            e.printStackTrace();
        }
    }
}
