package first_assignment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class Task3 
{

	public static void main(String[] args) throws Exception
	{
		int weight = 90;
		
		String op = ">";
		String fileXml = "people.xml";
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    
	    System.out.println("Loading " + fileXml + "...");
	    Document database = builder.parse(fileXml);
		
		System.out.println("Reading people who weight " + op + " " + weight + "...");
	    System.out.println("(using xpath = /people/person[./healthprofile/weight" + op + weight + "]/firstname/text())");
		
		XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
		
		try 
		{
			XPathExpression expr = xpath.compile("/people/person[./healthprofile/weight" + op + weight + "]/firstname/text()");
			Object result = expr.evaluate(database, XPathConstants.NODESET);
		    
			NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		        System.out.println(nodes.item(i).getNodeValue() + "\n");
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}
	}

}
