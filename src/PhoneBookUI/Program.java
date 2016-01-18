package PhoneBookUI;

import org.eclipse.swt.widgets.*;

public class Program {

	public static void main(String[] args) {
		// Ovo je SWT code:
		Display display = new Display();
		Shell shell = new Shell();
		shell.setText("Phone Book");
		shell.open();
		
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				display.sleep();
				
		display.dispose();
	}

}
