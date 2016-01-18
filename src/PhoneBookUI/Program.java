package PhoneBookUI;

import org.eclipse.swt.widgets.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell();
		shell.setText("Phone Book");
		shell.open();
		
		while(!shell.isDisposed())
			if(!display.readAndDispatch())
				
		display.dispose();
	}

}
