package phoneBookUI;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import phoneBookBusiness.PersonDataManager;
import phoneBookBusiness.PersonNavigationManager;
import phoneBookShared.Models.Person;

public class UserInterface {

	//private Label label;
	private Label lblFirstName;
	private Label lblLastName;
	private Label lblType;
	private Label lblCellPhone;
	private Label lblHomePhone;
	
	private Button deleteBtn;
	private Button cancleBtn;
	private Button saveBtn;
	private Button createNewBtn;
	private Button firstBtn;
	private Button previousBtn;
	private Button nextBtn;
	private Button lastBtn;
	private Button upDateBtn;
	private Button saveUpdateBtn;
	
	private Text textFirstName;
	private Text textLastName;
	private Text textType;
	private Text textCellPhone;
	private Text textHomePhone;
	
	private static int selectedPersonID;
	private Person createSessionPerson;
	private Boolean isUpdate;

	
	public UserInterface(Display display) {
		initUI(display);
	}

	public void initUI(Display display) {

		Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setLayout(new FillLayout());

		lblFirstName = new Label(shell, SWT.LEFT);
		lblFirstName.setText("First Name");
		setStylesLabel(lblFirstName, 10, 10);

		textFirstName = new Text(shell, SWT.SINGLE);
		setStylesText(textFirstName, 10, 10);

		lblLastName = new Label(shell, SWT.LEFT);
		lblLastName.setText("Last Name");
		setStylesLabel(lblLastName, 17, 17);

		textLastName = new Text(shell, SWT.SINGLE);
		setStylesText(textLastName, 17, 17);

		lblType = new Label(shell, SWT.LEFT);
		lblType.setText("Type");
		setStylesLabel(lblType, 24, 24);

		 textType = new Text(shell, SWT.SINGLE);
		 setStylesText(textType, 24, 24);

		lblCellPhone = new Label(shell, SWT.LEFT);
		lblCellPhone.setText("Cell Phone");
		setStylesLabel(lblCellPhone, 31, 31);

		textCellPhone = new Text(shell, SWT.SINGLE);
		setStylesText(textCellPhone, 31, 31);

		lblHomePhone = new Label(shell, SWT.LEFT);
		lblHomePhone.setText("Home Phone");
		setStylesLabel(lblHomePhone, 38, 38);
        	
		textHomePhone = new Text(shell, SWT.SINGLE);
		setStylesText(textHomePhone, 38, 38);

		FormLayout layout = new FormLayout();
		shell.setLayout(layout);

		deleteBtn = new Button(shell, SWT.BORDER);
		deleteBtn.setText("Delete");
		setStylesRightButtons(deleteBtn, 10);
		deleteBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					 
					 deleteSelected();
				 }
			 }
		});
		 
		cancleBtn = new Button(shell, SWT.PUSH);
		cancleBtn.setText("Cancel");
		setStylesRightButtons(cancleBtn, 40);
		cancleBtn.setVisible(false);
		cancleBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					 
					 saveBtn.setVisible(false);
					 cancleBtn.setVisible(false);
					 createNewBtn.setEnabled(true);
					 
					 setUiElements(createSessionPerson);
					 
					 //saveUpdateBtn.setVisible(false);
					 upDateBtn.setEnabled(true);
				 }
				 
			 }
		});
		
		saveBtn = new Button(shell, SWT.PUSH);
		saveBtn.setText("Save");
		setStylesRightButtons(saveBtn, 50);
		saveBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 // e je objekat koji prestavlja dagadjaj, njega salje automacki java negde u pozadini
				 // Ako je e.type == SWT.selection onda ce se izvrsiti medoda createNew.
				 if(e.type == SWT.Selection) {
					
					 if(isUpdate == false){
						 // Pozivam metodu koja kreira novi kontakt tako sto uzima podatke sa forme i prosledjuje bazi.
						 createNew();
						 
						 // Ovde sakrivamo save i cancel dugmice.
						 saveBtn.setVisible(false);
						 cancleBtn.setVisible(false);
						 // Ovde enejblujemo(osposobljavamo ga da radi) dugme createNewBtn.
						 createNewBtn.setEnabled(true);
						 upDateBtn.setEnabled(true);
					 } else if(isUpdate == true) {
						 
						   updateSelected();
							
						   saveBtn.setVisible(false);
						   cancleBtn.setVisible(false);
						   upDateBtn.setEnabled(true);
						   createNewBtn.setEnabled(true);
					 }
				 } 
			 }
		});
		saveBtn.setVisible(false);

		createNewBtn = new Button(shell, SWT.PUSH);
		createNewBtn.setText("Create New");
		setStylesRightButtons(createNewBtn, 60);
		createNewBtn.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					 
					 isUpdate = false;
					 
					 // Ovde pravimo dugmad save i cancel da budu vidljivi.
					 saveBtn.setVisible(true);
					 cancleBtn.setVisible(true);
					 // Ovde radimo disejbl(onemogucuje mu se rad)  dugmeta create.
					 createNewBtn.setEnabled(false);
					 upDateBtn.setEnabled(false);
					 
					 // Ovde setujemo trenutne podatke sa forme( Person) u globalnu varijablu koju cemo posle koristiti.
					 createSessionPerson = new Person();         // U ovom segmentu mi citamo elemente sa forme i dodeljujemo globalnoj varijabli. 
					 createSessionPerson = getUiElements();      // To bi mogli da uradimo i ovako: createSessionPerson = getUiElements();
//					 createSessionPerson.firstName = textFirstName.getText();
//					 createSessionPerson.lastName = textLastName.getText();
//					 createSessionPerson.cellPhone = textCellPhone.getText();
//					 createSessionPerson.id = selectedPersonID;
					 
					 // Ovde setujemo UI elements da budu prazni.
					 // Kao parametar metodi prosledjijemo prazan objekat.
					 setUiElements(new Person());
				 }
			}
		});
		
//		saveUpdateBtn = new Button(shell, SWT.PUSH);
//		saveUpdateBtn.setText("Save");
//		setStylesRightButtons(saveUpdateBtn, 50);
//		saveUpdateBtn.addListener(SWT.Selection, new Listener(){
//			public void handleEvent(Event e) {
//				
//				if(e.type == SWT.Selection){
//					
//					updateSelected();
//					
//					saveUpdateBtn.setVisible(false);
//					cancleBtn.setVisible(false);
//					upDateBtn.setVisible(true);
//				}
//			}
//		});
//		saveUpdateBtn.setVisible(false);
		
		
		upDateBtn = new Button(shell, SWT.PUSH);
		upDateBtn.setText("UpDate");
		setStylesRightButtons(upDateBtn, 70);
		upDateBtn.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					// Pozivam metodu koja ce abdejtovati selektovani kontakt.
					//updateSelected();
					 
					 isUpdate = true;
					 
					 saveBtn.setVisible(true);
					 cancleBtn.setVisible(true);
					 upDateBtn.setEnabled(false);
					 createNewBtn.setEnabled(false);
				 }
			}
		});
		
		firstBtn = new Button(shell, SWT.PUSH);
		firstBtn.setText("First");
		setStylesBottomButtons(firstBtn, 60, 30, 0);
		firstBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					 
					 moveFirst();
				 }
				 
			 }
		});

		previousBtn = new Button(shell, SWT.PUSH);
		previousBtn.setText("Previous");
		setStylesBottomButtons(previousBtn, 80, 30, 90);
		previousBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 // e je objekat koji prestavlja dagadjaj, njega salje automacki java negde u pozadini
				 // Ako je e.type == SWT.selection onda ce se izvrsiti medoda createNew.
				 if(e.type == SWT.Selection) {
					 
					 movePrevious();
				 }
				 
			 }
		});

		nextBtn = new Button(shell, SWT.PUSH);
		nextBtn.setText("Next");
		setStylesBottomButtons(nextBtn, 80, 30, 160);
		nextBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 // e je objekat koji prestavlja dagadjaj, njega salje automacki java negde u pozadini
				 // Ako je e.type == SWT.selection onda ce se izvrsiti medoda createNew.
				 if(e.type == SWT.Selection) {
					 
					 getNext();
				 }
				 
			 }
		});

		lastBtn = new Button(shell, SWT.PUSH);
		lastBtn.setText("Last");
		setStylesBottomButtons(lastBtn, 60, 30, 230);
		lastBtn.addListener(SWT.Selection, new Listener() {
			 public void handleEvent(Event e) {
			     
				 if(e.type == SWT.Selection) {
					 
					 moveLast();
				 }
				 
			 }
		});
		
		// Ovde kreiramo instancu objekta tipa PersonNavigationManager
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		
		// Metod getFirst() nam vraca prvi kontakt iz imenika 
		Person firstPerson = personNavigationManager.getFirst();
		
		// Prosledjujemo prvi kontakt metodi mapElements() koja postavlja vrednosti textBox-ova.
		setUiElements(firstPerson);
		
		shell.setText("PhoneBook");
		shell.pack();
		shell.setSize(400, 300);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}
	
	protected void updateSelected() {
		
		// Kreiramo novi objekat tipa Person i dodeljujemo vrednosti iz textboksova i id.
		Person uiData = new Person();
		uiData.firstName = textFirstName.getText(); // Ovde fildu firstName dodeljujemo tekst iz tekstboks firstName.
		uiData.lastName = textLastName.getText();   // Ovde i u sledecim primerima radimo slicno.
		uiData.cellPhone = textCellPhone.getText();
		uiData.id = selectedPersonID;
		//Person uiData = getUiElements();
		
		// Kreiramo novu instncu personDataMenager koji obezbedjuje funkcionalnosti(metode) za izmene podataka.
		PersonDataManager personDataManager = new PersonDataManager();
		// Ovde pozivamo metodu upData i prosledjujemo varijablu uiData.
		// uiData je tipa person i u njemu se cuvaju podaci sa forme. Mi ustvari saljemo podatke sa forme.
		personDataManager.upDate(uiData);
		
	}

	protected void moveFirst() {
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		Person nextPerson = personNavigationManager.getFirst();
		
		setUiElements(nextPerson);
	}

	protected void deleteSelected() {
		
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		Person nextPerson = personNavigationManager.getNext(selectedPersonID);
		
		PersonDataManager personDataManager = new PersonDataManager();
		personDataManager.delete(selectedPersonID);
		
		if(nextPerson == null){
			Person emptyPerson = new Person();
			setUiElements(emptyPerson);
		} else {
			setUiElements(nextPerson);
		}
		
	}

	protected void moveLast() {
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		Person lastPerson = personNavigationManager.getLast();
		
		setUiElements(lastPerson);
	}

	protected void movePrevious() {
		
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		Person previousPerson = personNavigationManager.getPrevious(selectedPersonID);
		
		setUiElements(previousPerson);
	}

	protected void getNext() {
		
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		Person nextPerson = personNavigationManager.getNext(selectedPersonID);
		
		setUiElements(nextPerson);
	}

	private void createNew() {
	
		// Ovde kupimo podatke sa UI forme i konvertujemo u Person objekat.
		Person uiData = getUiElements();
		
		PersonDataManager dataManager = new PersonDataManager();
		selectedPersonID = dataManager.create(uiData);
		
		
	}

	private void setStylesLabel(Label label, int x, int y) {
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, 10);
		data.top = new FormAttachment(x, y);
		label.setLayoutData(data);
		
	}
	
	private void setStylesText(Text text, int x, int y){
		FormData data = new FormData();
		data.left = new FormAttachment(lblFirstName, 15);
		data.top = new FormAttachment(x, y);
		data.right = new FormAttachment(60, -25);
		text.setLayoutData(data);
	}
	
	private void setStylesRightButtons(Button button, int x){
		FormData Data = new FormData(100, 30);
		Data.right = new FormAttachment(98);
		Data.top = new FormAttachment(x);
		button.setLayoutData(Data);
	}
	
	private void setStylesBottomButtons(Button button, int x, int y, int z){
		FormData Data = new FormData(x, y);
		Data.right = new FormAttachment(firstBtn, z, SWT.RIGHT);
		Data.bottom = new FormAttachment(88);
		button.setLayoutData(Data);
	}
	
	private void setUiElements(Person p){
		// Ovaj metod dobija kao argument objekat tipa Person i njegove fildove(vrednosti iz fildova) dodeljuje textBox-ovima.
		// TexBox-ovi su dostupni u ovoj metodi zato sto su globalni, tj. zato sto su deklarisani u klasi i mogu se videti u citavoj klasi.
		
		if(p != null){
		// Inverzni if izvrsava se samo ako je p razlicito od nule, zato se zove inverzni if jer trazi razlicitost a ne jednakost.
			
			selectedPersonID = p.id;
			textFirstName.setText(p.firstName);
			textLastName.setText(p.lastName);
			textType.setText("N/A");
			textCellPhone.setText(p.cellPhone);
			textHomePhone.setText("N/A");
		} 
	}
	
	private Person getUiElements(){
		
		// Kreiramo instancu objekta
		Person p = new Person();
		
		// Fildu objekta p dodeljujem vrednost iz tekst boksa:
		p.firstName = textFirstName.getText(); 
		p.lastName = textLastName.getText();
		p.cellPhone = textCellPhone.getText();
		p.id = selectedPersonID;
		
		// Vraca objekat p sa dodeljenim vrednostima.
		return p;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Display display = new Display();
		UserInterface us = new UserInterface(display);
		display.dispose();
	}

}
