package phoneBookBusiness;

import java.util.List;

import phoneBookData.PersonDataAccess;
import phoneBookShared.Models.Person;

public class PersonNavigationManager {

	public void initialize(){
		
		PersonDataAccess dataAccess = new PersonDataAccess();
		List<Person> allPersons = dataAccess.read();
		
		//PersonEntities.getInstance().AllPersons = allPersons;
		PersonEntities entities = PersonEntities.getInstance();
		entities.AllPersons = allPersons;
	}
	
	public Person getFirst(){
		
		List<Person> allPersons = PersonEntities.getInstance().AllPersons;
		
		return allPersons.get(0);	
	}
}
