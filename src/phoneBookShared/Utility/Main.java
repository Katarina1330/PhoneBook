package phoneBookShared.Utility;

import java.io.FileReader;
import java.io.IOException;

import phoneBookShared.Models.Person;

import java.util.ArrayList;
import java.util.List;

import phoneBookData.PersonDataAccess;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//FileReader fr = new FileReader();
		//System.out.println(fr.read("/Users/Katarina/Documents/File.txt"));

		//FileWriterPhoneBook.creatingEmptyFile("/Users/Katarina/Documents/FileWrite.txt");
		
		//FileWriterPhoneBook.writeToFile("/Users/Katarina/Documents/FileWrite.txt", "Telefonski imenik");
		
//		Person p = new Person();
//		p.id = 1;
//		p.firstName = "Ika";
//		p.lastName = "Ikac";
//		p.cellPhone = "6508630563";
//		
//		Person p2 = new Person();
//		p2.id = 1;
//		p2.firstName = "Ika";
//		p2.lastName = "Ikac";
//		p2.cellPhone = "6508630563";
//		
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(p);
//		persons.add(p2);
//		
//		XmlSerializer xml = new XmlSerializer();
//		String result = xml.serialize(persons);
//		
//		System.out.println(result);
		
//		phoneBookShared.Utility.FileReaderPhoneBook fr = new phoneBookShared.Utility.FileReaderPhoneBook();
//		String result = fr.read("/Users/Katarina/Documents/FileWrite.txt");
//		
//		XmlSerializer xs = new XmlSerializer();
//		List<Person> persons = xs.deserialize(result);
//		
//		for (Person p : persons) {
//			System.out.println(p.id + " " + p.cellPhone + " " + p.firstName + " " + p.lastName);
//		}
		
		
		
//1. Read:
		PersonDataAccess pda = new PersonDataAccess();
		//System.out.println(pda.read());
		List<Person> persons = pda.read();
		
		for (Person p : persons) {
			System.out.println(p.id + " " + p.cellPhone + " " + p.firstName + " " + p.lastName);
		}
		
		
//2. Create:
//		Person p = new Person();
//		p.id = 1;
//		p.firstName = "Ika";
//		p.lastName = "Ikac";
//		p.cellPhone = "6508630563";
//
//		Person p2 = new Person();
//		p2.id = 1;
//		p2.firstName = "Ika";
//		p2.lastName = "Ikac";
//		p2.cellPhone = "6508630563";
//		
//		Person p3 = new Person();
//		p3.id = 2;
//		p3.firstName = "Kaca";
//		p3.lastName = "Kacasti";
//		p3.cellPhone = "98567790";
//
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(p);
//		persons.add(p2);
//		persons.add(p3);
//
//		PersonDataAccess pda = new PersonDataAccess();
//		pda.create(persons);

	}

}
