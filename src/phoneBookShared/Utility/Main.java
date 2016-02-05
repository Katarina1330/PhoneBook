package phoneBookShared.Utility;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//FileReader fr = new FileReader();
		//System.out.println(fr.read("/Users/Katarina/Documents/File.txt"));

		//FileWriterPhoneBook.creatingEmptyFile("/Users/Katarina/Documents/FileWrite.txt");
		
		FileWriterPhoneBook.writeToFile("/Users/Katarina/Documents/FileWrite.txt", "Telefonski imenik");
		
	}

}
