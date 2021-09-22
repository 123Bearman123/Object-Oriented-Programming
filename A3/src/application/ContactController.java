package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ContactController implements Serializable {

	
	ContactList cl;
	
	public ContactController(){
		// constructor
		cl = new ContactList();
	}
	
	public void printList()
	{
		System.out.println(cl);
	}
	
	public void addContactToList(String cFName,String CLNamm, String Cid, String CPhone)
	{
		int id = Integer.parseInt(Cid);
		int phone = Integer.parseInt(CPhone);
		Contact c = new Contact(cFName, CLNamm, id, phone); // object of type car
		cl.addContact(c);
	}

	public void remContactByName(String cFName,String CLNamm, String Cid, String CPhone)
	{
		for (int i = 0 ; i< cl.getSize(); i++)
			if ((cl.getContact(i).getFName().equals(cFName)) && (cl.getContact(i).getLName().equals(CLNamm))) { 
					cl.removeContact(cl.getContact(i));
			}
	}
	
	public void saveAllList(){
	  try{
		PrintWriter outputFile = new PrintWriter("ContactList.txt");
	            {
	             for(int i = 0; i < cl.getSize(); i++) { 
	            	 outputFile.println(cl.getContact(i));
	             }
	            }
	     outputFile.close();
	    }
	   catch (FileNotFoundException e) {
		   System.out.println("could not save");
	   }
	 }
	
	void  loadAllList() throws IOException{
	  try {
	  	BufferedReader reader;
	   {
		 reader = new BufferedReader(new FileReader("ContactList.txt"));
	     String line = reader.readLine();
	     while (line != null) {
	    	 System.out.println(line);
	     	 line = reader.readLine();
	     	 
	     }
	   } 
	  reader.close();
	  }
	   
	   catch (FileNotFoundException e) {
	     System.out.println("could not load");
	   }
	}
	

	 
	public String getListContact()
	{
		String allContact="\0";
		for (int i = 0;i<cl.getSize();i++)
		{
		    allContact = allContact+cl.getContact(i);	
		}	
		return allContact;
	}
}