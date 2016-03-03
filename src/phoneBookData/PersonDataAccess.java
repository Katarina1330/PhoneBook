package phoneBookData;

import java.io.IOException;
import java.util.List;

import phoneBookShared.Models.Person;
import phoneBookShared.Utility.FileReaderPhoneBook;
import phoneBookShared.Utility.FileWriterPhoneBook;
import phoneBookShared.Utility.XmlSerializer;

public class PersonDataAccess {
	
	public List<Person> read(){
		
		FileReaderPhoneBook fr = new FileReaderPhoneBook();
		String resalt = fr.read("/Users/Katarina/Documents/FileWrite.txt");
		
		XmlSerializer xs = new XmlSerializer();
		List<Person> persons = xs.deserialize(resalt);
		
		return persons;
	}
	
	public void write(List<Person> p) throws IOException{
		
		XmlSerializer xs = new XmlSerializer();
		String resalt = xs.serialize(p);
		
		FileWriterPhoneBook fw = new FileWriterPhoneBook();
		fw.writeToFile("/Users/Katarina/Documents/FileWrite2.txt", resalt);
	}

}
