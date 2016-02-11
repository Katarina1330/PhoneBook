package phoneBookShared.Utility;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import phoneBookShared.Models.Person;

public class XmlSerializer {

	public String serialize(List<Person> persons){
		
		if( persons == null )
        {
            return null;
        }
        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        final XMLEncoder encoder = new XMLEncoder( bout );
        encoder.writeObject( persons );
        encoder.close();
        return new String( bout.toByteArray() );
	}
	
	public List<Person> deserialize(String s){
		
		 if( s == null )
	        {
	            return null;
	        }
	        final ByteArrayInputStream bin = new ByteArrayInputStream( s.getBytes() );
	        final XMLDecoder decoder = new XMLDecoder( bin );
	        return (List<Person>) decoder.readObject();
	}

	
}
