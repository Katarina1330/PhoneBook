package phoneBookBusiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phoneBookData.PersonDataAccess;
import phoneBookShared.Models.Person;

// Ova klasa sluzi da vrsi izmene na Person podacima
public class PersonDataManager {

	public void create(Person person) {
		
		// Kreiramo objekat tipa PersonDataAccess koji nam obezbedjuje funkcionlnosti citanja iz baze i pisanja u bazu.
		PersonDataAccess dataAccess = new PersonDataAccess();
		
		// Ovde citamo ceo sadrzaj iz baze i dobijamo sve Person-se.
		List<Person> allPerson = dataAccess.read();
		
		// Proveravamo da li je allPerson == null, ako je null onda cemo dodeliti praznu listu
		if(allPerson == null){
			allPerson = new ArrayList<Person>();
		}
		// Ovde dodajemo novi kontakt postojecim kontaktima.
		allPerson.add(person);
		
		// Ovde stari sadrzaj iz xml fajla zamenjujemo sa novim podacima.
		// Novi podaci su: stari + novi Person
		try {
			dataAccess.write(allPerson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
