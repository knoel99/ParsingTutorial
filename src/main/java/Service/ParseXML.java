package Service;

import Model.User;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXML {
    public ArrayList<User> parseXML(String filePath){
        ArrayList<User> userList = new ArrayList<User>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            String xpathExpressionName = "";
            String xpathExpressionAge = "";

            /*******Get attribute values using xpath******/

            //Get all persons name and age
            xpathExpressionName = "/root/person/name/text()";
            xpathExpressionAge = "/root/person/age/text()";

            ArrayList<String> nameList = new ArrayList<String>(this.evaluateXPath(doc, xpathExpressionName));
            ArrayList<String> ageList = new ArrayList<String>(this.evaluateXPath(doc, xpathExpressionAge));

            for (int i=0 ; i<nameList.size() ; i++){
                userList.add(new User(nameList.get(i), Integer.parseInt(ageList.get(i))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }


    private List<String> evaluateXPath(Document document, String xpathExpression) throws Exception {
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        List<String> values = new ArrayList<>();

        try {
            // Create XPathExpression object
            XPathExpression expr = xpath.compile(xpathExpression);

            // Evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                values.add(nodes.item(i).getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return values;
    }
}