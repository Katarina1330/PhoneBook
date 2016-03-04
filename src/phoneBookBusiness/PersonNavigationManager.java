package phoneBookBusiness;

import java.util.List;

import phoneBookData.PersonDataAccess;
import phoneBookShared.Models.Person;

public class PersonNavigationManager {

	
	
	public Person getFirst(){
		
		PersonDataAccess dataAccess = new PersonDataAccess();
		List<Person> allPersons = dataAccess.read();
		
		// Ovde proveravamo da li allPersons sadrzi neke podatke ili je jednako null
		if(allPersons != null){
			// Ako nije null, onda cemo vratiti prvi prson sa liste
			return allPersons.get(0);
		}
		
		// Ukoliko je allPersons null onda vracamo prazan objekat 
		return new Person();	
	}
}
