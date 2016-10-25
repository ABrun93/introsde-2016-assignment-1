package laboratory;

import java.io.IOException;

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

public class GetHeightAndWeight 
{
	private static Document database;
	
	public GetHeightAndWeight(String fileXml) 
	{ 
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	   		
	    try 
		{
	    	DocumentBuilder builder = domFactory.newDocumentBuilder();
			
			System.out.println("Loading " + fileXml + "...");			
			database = builder.parse(fileXml);
		} 
	    catch (ParserConfigurationException | SAXException | IOException e) 
	    {
			e.printStackTrace();
		}
	}
	
	public static String execute(String path)
	{
	    String res = "";
		
		System.out.println("(using xpath = " + path + ")");
		
		XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
		
		try 
		{
			XPathExpression expr = xpath.compile(path);
			Object result = expr.evaluate(database, XPathConstants.NODESET);
		    
			NodeList nodes = (NodeList) result;
		    for (int i = 0; i < nodes.getLength(); i++) 
		    {
		    	 res = res + nodes.item(i).getTextContent();
		    }
		} 
		catch (XPathExpressionException e) 
		{
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static String getHeight(int id)
	{
		return "Height: " + execute("/people/person[@id="+id+"]/healthprofile/height");
	}
	
	public static String getWeight(int id)
	{
		return "Weight: " + execute("/people/person[@id="+id+"]/healthprofile/weight");
	}

	public static void main(String[] args) 
	{
		int id = 1;
		String fileXml = "people.xml";
		
		GetHeightAndWeight lab = new GetHeightAndWeight(fileXml);
		
		System.out.println(id + ".");
	    System.out.println(getHeight(id));
	    System.out.println(getWeight(id));
	}

}
