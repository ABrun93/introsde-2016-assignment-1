package first_assignment;

import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import model.People;
import model.Person;
import model.HealthProfile;;

public class Task5 {

	public static void main(String[] args)throws Exception 
	{
		JAXBContext jc = JAXBContext.newInstance(People.class);

		System.out.println("\nOutput from our XML File: ");
        
		Unmarshaller um = jc.createUnmarshaller();
        People people = (People) um.unmarshal(new FileReader("people.xml"));
        List<Person> list = people.getData();
        
        for (Person person : list) 
        {
        	System.out.println("Person: " + person.getFirstname() + " born " + person.getBirthdate());
        }
	}
}
