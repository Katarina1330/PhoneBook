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
	
	public Person getNext(int id){
		
		PersonDataAccess personDataAccess = new PersonDataAccess();
		List<Person> allPersons = personDataAccess.read();
		
		
		for (int i = 0; i < allPersons.size(); i++) {
			Person current = allPersons.get(i);
			if(current.id == id && i < allPersons.size() - 1){
				return allPersons.get(i + 1);
			} 
		}
		
		return null;
	}
	
	public Person getPrevious(int id){
		
		PersonDataAccess personDataAccess = new PersonDataAccess();
		List<Person> allPersons = personDataAccess.read();
		
		for (int i = 0; i < allPersons.size(); i++) {
			Person current = allPersons.get(i);
			
			if(current.id == id && i > 0){
				 return allPersons.get(i - 1);
			}
		}
		
		return null;
	}
}
