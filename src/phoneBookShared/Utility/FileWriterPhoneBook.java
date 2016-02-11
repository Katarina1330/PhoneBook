package phoneBookShared.Utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import phoneBookShared.Models.Person;

public class FileWriterPhoneBook {
	
	

	public void writeToFile(String fileName, String str) throws IOException{
		
		creatingEmptyFile(fileName);
		
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
		fw.close();
		
		
	}
	
	public void creatingEmptyFile(String fileName){
		
		File myFile = new File(fileName);
		try{
			myFile.createNewFile();
			System.out.println("Created: " + myFile.getPath());
		} catch(Exception e){
			System.out.println("Don't created: " + myFile.getPath());
		}
	}
}
