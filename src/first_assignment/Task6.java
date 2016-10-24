package first_assignment;

import java.io.File;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import model.People;
import model.Person;
import model.HealthProfile;

public class Task6 {

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
		
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        String result = mapper.writeValueAsString(database);
        System.out.println(result);
        mapper.writeValue(new File("marshaller_people.json"), database);	
	}

}
