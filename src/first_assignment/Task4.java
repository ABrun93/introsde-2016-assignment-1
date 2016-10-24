package first_assignment;

import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.People;
import model.Person;
import model.HealthProfile;

public class Task4 {

	public static void main(String[] args) throws Exception
	{
		People database = new People();
		
		HealthProfile hpA = new HealthProfile(68.0, 1.78, new Date());
		Person personA = new Person(new Long(1), "Andrea", "Brun", new Date(), hpA);
		
		database.getData().add(personA);
		
		HealthProfile hpB = new HealthProfile(80, 1.54, new Date());
		Person personB = new Person(new Long(13), "Olivia", "Powell", new Date(), hpB);
		
		database.getData().add(personB);
				
		HealthProfile hpC = new HealthProfile(90, 1.86, new Date());
		Person personC = new Person(new Long(15), "Riccardo", "Coinquilino", new Date(), hpC);
		
		database.getData().add(personC);
		
		JAXBContext jc = JAXBContext.newInstance(People.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        m.marshal(database,new File("file/people.xml"));
        m.marshal(database, System.out);
	}

}
