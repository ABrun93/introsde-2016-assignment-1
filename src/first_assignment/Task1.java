package first_assignment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Task1 
{

	public static void main(String[] args) throws Exception
	{
		String fileXml, id, fname, lname, birthday, weight, height;
		fileXml = "people.xml";
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    
	    System.out.println("Loading " + fileXml + "...");
	    Document database = builder.parse(fileXml);
	    
	    System.out.println("Reading list of people...");
	    System.out.println("(using xpath = /people/person)");
		
		XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
		
		XPathExpression expr = xpath.compile("/people/person");
		Object result = expr.evaluate(database, XPathConstants.NODESET);
	    
		NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) 
	    {
	    	 System.out.println("Id "+nodes.item(i).getAttributes().getNamedItem("id").getTextContent()+".");
	    	 System.out.println(nodes.item(i).getTextContent());
	    }
	}
}
