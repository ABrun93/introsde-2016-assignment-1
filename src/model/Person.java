package model;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")	
@XmlType(propOrder = { "firstname", "lastname", "birthdate", "hProfile" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Person 
{
	private String firstname;		
	private String lastname;	
	private Date birthdate;
	
	@XmlElement(name="healthprofile")
	private HealthProfile hProfile;	
	
	@XmlAttribute(name="id")
	private Long personId;
	
	public Person(Long personId, String fname, String lname, Date birthdate, HealthProfile hp) {
		this.setPersonId(personId); 	
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate); 	
		this.hProfile=hp;
	}
	
	public Person(Long personId, String fname, String lname, Date birthdate) {
		this.setPersonId(personId); 	
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate); 
		this.hProfile=new HealthProfile();
	}
	
	public Person() {
		this.firstname="Pinco";
		this.lastname="Pallino";
		this.hProfile=new HealthProfile();

		// Setting personId to a random number between 1 and 9999
		this.personId = Math.round(Math.floor(Math.random()*9998)+1); // Solution to Exercise #01-1d
		this.birthdate = this.getRandomDate();
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public HealthProfile getHProfile() {
		return hProfile;
	}
	public void setHProfile(HealthProfile hProfile) {
		this.hProfile = hProfile;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	// Creating a random date between now and 1950
	private Date getRandomDate() 
	{
		Date res = null;
		// Get the current year
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		// Generate a random year between 1950 and currentYear
		int year = (int) Math.round(Math.random()*(currentYear-1950)+1950); 
		// Select a random month of the year																	
		int month = (int) Math.round(Math.floor(Math.random()*11)+1);		
		// Select a random day in the selected month
		int[] months = new int[]{31,28,30,30,31,30,31,31,30,31,30,31};	// Days in each month
		// If it is a leap year, feb (months[1]) should be 29
		if ((currentYear % 4 == 0) && ((currentYear % 100 != 0) || (currentYear % 400 == 0))) 
		{
			months[1] = 29;
		}
		long day = Math.round(Math.floor(Math.random()*(months[month-1]-1)+1));
		// TODO: Converti in formato data
		return res;
	}
}