package phoneBookShared.Utility;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import phoneBookShared.Models.Person;

public class PersonDataAccess {
	
	public List<Person> read(){
		
		FileReaderPhoneBook fr = new FileReaderPhoneBook();
		String resalt = fr.read("/Users/Katarina/Documents/FileWrite.txt");
		
		XmlSerializer xs = new XmlSerializer();
		List<Person> persons = xs.deserialize(resalt);
		
		
//		for (Person p : persons) {
//			 String pl = p.id + p.firstName;
//			
//		}
		
		return persons;
	}
	
	public void create(List<Person> p) throws IOException{
		
		XmlSerializer xs = new XmlSerializer();
		String resalt = xs.serialize(p);
		
		
		
		FileWriterPhoneBook fw = new FileWriterPhoneBook();
		fw.writeToFile("/Users/Katarina/Documents/FileWrite2.txt", resalt);
	}

}
