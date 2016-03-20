package phoneBookBusiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phoneBookData.PersonDataAccess;
import phoneBookShared.Models.Person;

// Ova klasa sluzi da vrsi izmene na Person podacima
public class PersonDataManager {

	public int create(Person person) {
		
		// Kreiramo objekat tipa PersonDataAccess koji nam obezbedjuje funkcionlnosti citanja iz baze i pisanja u bazu.
		PersonDataAccess dataAccess = new PersonDataAccess();
		
		// Ovde citamo ceo sadrzaj iz baze i dobijamo sve Person-se.
		List<Person> allPerson = dataAccess.read();
		
		// Proveravamo da li je allPerson == null, ako je null onda cemo dodeliti praznu listu
		// Ako je allPerson null , to znaci da nemamo nikog u bazi. Ako nemamo nikog u bazi onda ce person prvi biti.
		// Posto je person prvi , negov id ce biti jedan.
		if(allPerson == null || allPerson.isEmpty()){
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
		
		return person.id;
	}

	public void delete(int id) {
		
		PersonDataAccess personDataAccess = new PersonDataAccess();
		List<Person> allPersons = personDataAccess.read();
		
		for (int i = 0; i < allPersons.size(); i++) {
			
			if(allPersons.get(i).id == id) {
				allPersons.remove(i);
				break;
			}
		}
		
		try {
			personDataAccess.write(allPersons);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Metoda vrsi update postojeceg kontakta. 
	// Kao parametar prima Person objekat koji sadrzi nove podatke i oni ce biti insertovani na mestu odgovarajuceg starog objekta. 
	public void upDate(Person p){
		
		// Kreiramo personDataAccess objekat koji obezbedjuje funkcionalnosti(metode) za pisanje i citanje iz baze. 
		PersonDataAccess personDataAccess = new PersonDataAccess();
		// Ovde citamo sve Persone iz baze sa metodom read.
		List<Person> allPerson = personDataAccess.read();
		
		
		// Sada prolazimo kroz sve elemente kolekcije Person u potrazi za odgovarajucim objektom.
		for (int i = 0; i < allPerson.size(); i++) {
			// Ovaj uslov ce biti tacan kada id objekta iz kolekcije bude jednak id-ju objekta kog smo poslali iz UI.
			// Posto se radi update mi moramo da nadjemo isti kontakt koji je poslat sa UI i to se radi preko id-a. 
			if(allPerson.get(i).id == p.id) {
				// Kada smo nasli kontakt koji ima isti id onda uzimamo indeks na kojem se on nalazi u kolekciji.
				// Onda pozivamo metod set koji ce ubaciti novi objekat Person na mestu starog.
				// Cilj je prakticno da se nadje indeks starog objekta kako bi se on zamenio sa novim objektom.
				allPerson.set(i, p);
				break;
			}
		}
		
		try {
			// Ovde sada upisujemo u bazu kolekciju koju smo modifikovali.
			personDataAccess.write(allPerson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
