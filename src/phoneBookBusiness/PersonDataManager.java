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
		// Ako je allPerson null , to znaci da nemamo nikog u bazi. Ako nemamo nikog u bazi onda ce person prvi biti.
		// Posto je person prvi , negov id ce biti jedan.
		if(allPerson == null){
			allPerson = new ArrayList<Person>();
			person.id = 1;
		} else {
			// Ako allPerson nije null to znaci da id novog person-a mora biti veci od id zadnjeg person-a u bazi.
			Person last = allPerson.get(allPerson.size() - 1);
			person.id = last.id + 1;
		}
		// Ovde dodajemo novi kontakt postojecim kontaktima.
		allPerson.add(person);
		
		// Ovde stari sadrzaj iz xml fajla zamenjujemo sa novim podacima.
		// Novi podaci su: stari + novi Person
		try {
			dataAccess.write(allPerson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
