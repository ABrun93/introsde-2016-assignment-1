package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import model.Person;

@XmlRootElement(name="people")
@XmlAccessorType(XmlAccessType.FIELD)
public class People 
{
	@XmlElement(name="person")
	private List<Person> data = new ArrayList<Person>();
	
	public People() { }

	public List<Person> getData() {
		return data;
	}

	public void setData(List<Person> data) {
		this.data = data;
	}
}
