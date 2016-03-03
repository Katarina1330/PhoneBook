package phoneBookUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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
	
	private Text textFirstName;
	private Text textLastName;
	private Text textType;
	private Text textCellPhone;
	private Text textHomePhone;
	

	// TODO: Remove unused import
	// Provide appropriate names for all variables ( Don't use abbreviations).
	// Put all form elements to be global in class.
	// Apply styles according to phonBook schema
	// Create Map method.
	public UserInterface(Display display) {
		initUI(display);
	}

	public void initUI(Display display) {

		Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		//shell.setLayout(new FormLayout());
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

//		 FormLayout layout = new FormLayout();
//		 layout.marginLeft = 50;
//		 layout.marginTop = 30;
//		 layout.spacing = 30;
//		 shell.setLayout(layout);
//		
//		 Combo combo = new Combo(shell, SWT.DROP_DOWN);
//		 combo.add("Ubuntu");
//		 combo.add("Fedora");
//		 combo.add("Arch");
//		 combo.add("Red Hat");
//		 combo.add("Mint");
//		 combo.setLayoutData(new RowData(150, -1));
//
//		 label = new Label(shell, SWT.LEFT);
//		 label.setText("...");
//
//		 combo.addListener(SWT.Selection, event -> onSelected(combo));

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
		 
      // Color red = display.getSystemColor(SWT.COLOR_RED);

		//TableItem item = new TableItem(deleteBtn, SWT.NONE);
//	    item.setBackground(red);
       
		cancleBtn = new Button(shell, SWT.PUSH);
		cancleBtn.setText("Cancel");
		setStylesRightButtons(cancleBtn, 40);

		saveBtn = new Button(shell, SWT.PUSH);
		saveBtn.setText("Save");
		setStylesRightButtons(saveBtn, 50);

		createNewBtn = new Button(shell, SWT.PUSH);
		createNewBtn.setText("Create New");
		setStylesRightButtons(createNewBtn, 60);

		firstBtn = new Button(shell, SWT.PUSH);
		firstBtn.setText("First");
		setStylesBottomButtons(firstBtn, 60, 30, 0);

		previousBtn = new Button(shell, SWT.PUSH);
		previousBtn.setText("Previous");
		setStylesBottomButtons(previousBtn, 80, 30, 90);

		nextBtn = new Button(shell, SWT.PUSH);
		nextBtn.setText("Next");
		setStylesBottomButtons(nextBtn, 80, 30, 160);

		lastBtn = new Button(shell, SWT.PUSH);
		lastBtn.setText("Last");
		setStylesBottomButtons(lastBtn, 60, 30, 230);
		
		// Ovde kreiramo instancu objekta tipa PersonNavigationManager
		PersonNavigationManager personNavigationManager = new PersonNavigationManager();
		// Ovde pozivam metodu initialize() koja inicijalizuje personEntitis
		personNavigationManager.initialize();
		
		// Metod getFirst() nam vraca prvi kontakt iz imenika 
		Person firstPerson = personNavigationManager.getFirst();
		
		// Prosledjujemo prvi kontakt metodi mapElements() koja postavlja vrednosti textBox-ova.
		setUiElements(firstPerson);
		
		getUiElements();
		
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
	

//	private void onSelected(Combo combo) {
//
//		label.setText(combo.getText());
//		label.pack();
//	}
	
	private void setUiElements(Person p){
		// Ovaj metod dobija kao argument objekat tipa Person i njegove fildove(vrednosti iz fildova) dodeljuje textBox-ovima.
		// TexBox-ovi su dostupni u ovoj metodi zato sto su globalni, tj. zato sto su deklarisani u klasi i mogu se videti u citavoj klasi.
		
		textFirstName.setText(p.firstName);
		textLastName.setText(p.lastName);
		textType.setText("N/A");
		textCellPhone.setText(p.cellPhone);
		textHomePhone.setText("N/A");
	}
	
	private Person getUiElements(){
		
		Person p = new Person();
		setUiElements(p);
		
		textFirstName.getText();
		textLastName.getText();
		textType.getText();
		textCellPhone.getText();
		textHomePhone.getText();
		
	
		return p;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Display display = new Display();
		UserInterface us = new UserInterface(display);
		display.dispose();
		
		
		
	}

}
