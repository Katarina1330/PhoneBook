package phoneBookShared.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterPhoneBook {
	
	

	public static void writeToFile(String fileName, String str) throws IOException{
		
		creatingEmptyFile(fileName);
		
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
		fw.close();
		
	}
	
	public static void creatingEmptyFile(String fileName){
		
		File myFile = new File(fileName);
		try{
			myFile.createNewFile();
			System.out.println("Created: " + myFile.getPath());
		} catch(Exception e){
			System.out.println("Don't created: " + myFile.getPath());
		}
	}
}
