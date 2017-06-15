import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.Properties;

/**
 * Created by Kekko on 13/06/2017.
 */
public class PropertiesGetInfo {

    public PropertiesGetInfo() {

    }

    public String getInfo(String campo) {
        try {
            File fXmlFile = new File("src/main/resources/application.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("properties");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (campo.equals("user")) return eElement.getElementsByTagName("user").item(0).getTextContent();
                    if (campo.equals("pass")) return eElement.getElementsByTagName("password").item(0).getTextContent();
                    if (campo.equals("server")) return eElement.getElementsByTagName("server").item(0).getTextContent();
                    if (campo.equals("database")) return eElement.getElementsByTagName("database").item(0).getTextContent();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}