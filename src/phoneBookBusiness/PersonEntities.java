package phoneBookBusiness;

import java.util.List;

import phoneBookShared.Models.Person;

public class PersonEntities {

	
	private static PersonEntities instance = null;
	
	public List<Person> AllPersons;
	
	protected PersonEntities(){
		
	}
	
	
	public static PersonEntities getInstance(){
		
		if(instance == null) {
			instance = new PersonEntities();
		}
		
		return instance;
	}
}
