package phoneBook.Shared.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

	public String read(String s) {

		File billFile = new File(s);

		byte[] content = new byte[0];
		try {
			FileInputStream billInputStream = new FileInputStream(billFile);
			int bytesAvailable = billInputStream.available();

			content = new byte[bytesAvailable];

			billInputStream.read(content);
			billInputStream.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Couldn't find a file called " + s);
		} catch (IOException ioe) {
			System.out.println("Couldn't read a file called " + s);
		}
		
		return new String(content);
	}

}
