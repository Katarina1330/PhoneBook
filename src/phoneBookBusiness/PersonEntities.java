package phoneBookBusiness;

import java.util.List;

import phoneBookShared.Models.Person;

public class PersonEntities {

	
	public static PersonEntities getAllPerson;
	
	protected PersonEntities(){
		
	}
	
	
	public static PersonEntities getInstance(){
		
		if(getAllPerson == null) {
			getAllPerson = new PersonEntities();
		}
		
		return getAllPerson;
	}
}
