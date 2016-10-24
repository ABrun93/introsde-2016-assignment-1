package first_assignment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class Task2 
{

	public static void main(String[] args) throws Exception
	{
		int id = 5;
		String fileXml = "people.xml";
		
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    
	    System.out.println("Loading " + fileXml + "...");
	    Document database = builder.parse(fileXml);
		
		System.out.println("Reading " + Long.toString(id) + "'s health profile...");
		System.out.println("(using xpath = /people/person[@id="+ id +"]/healthprofile)");
		
		XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
		
		XPathExpression expr = xpath.compile("/people/person[@id="+ id +"]/healthprofile");
		Object result = expr.evaluate(database, XPathConstants.NODESET);
	    
		NodeList nodes = (NodeList) result;
	    for (int i = 0; i < nodes.getLength(); i++) 
	    {
	    	System.out.println(nodes.item(i).getTextContent());
	    }
	}

}
