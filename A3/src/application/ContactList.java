package application;

import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("serial")
public class ContactList implements Serializable {
	
	 public static ArrayList <Contact> Contact;

	 public ContactList (){ 
		 // constructor
		 Contact = new ArrayList <Contact> ();
	 }
	 
	 public ArrayList <Contact> getList (){
	     return Contact;
	 }
	 
	public void addContact(Contact c)
	{
		Contact.add(c);
	}
	

	
	public void addContactToList(String cFName,String CLNamm, String Cid, String CPhone)
	{
		int id = Integer.parseInt(Cid);
		int phone = Integer.parseInt(CPhone);
		Contact c = new Contact(cFName, CLNamm, id, phone); // object of type car
		Contact.add(c);
	}
	
	public void removeContact(Contact c)
	{
		Contact.remove(c);
	} 

	
	public void remContactByName(String name)
	{
		for (int i = 0 ; i< Contact.size(); i++)
			if (getContact(i).getFName().equals(name))
				Contact.remove(i);
	}
	
	public Contact getContact(int i)
	{
		if ((i>-1) && (i < Contact.size()))
			// check that the index is valid
     		return Contact.get (i);
		return null;
	}
	
	public static void saveAllList()
	  {
	  try
	   {
	    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("carlist.txt"));
	            {
	             os.writeObject(Contact);
	            }
	    os.close();
	    } catch (Exception ex) {
	     System.out.println("could not save");
	     ex.printStackTrace();
	   }
	 }

	
	@SuppressWarnings("unchecked")
	public
	void  loadAllList()
	  {
	  try
	   {
	     ObjectInputStream is = new ObjectInputStream(new FileInputStream("carlist.txt"));  
	     Contact = (ArrayList<Contact>) is.readObject();
	     System.out.println(""+Contact.size()+" cars in the list\n");
	     System.out.println(listAllContacts());
	     is.close() ;       
	   } 
	   catch (Exception ex) {
	     System.out.println("could not load");
	     ex.printStackTrace();
	   }
	      }
	
	public String listAllContacts()
	{
		String list = "";
		for (Contact c : Contact)
		{
			list +=  "First Name:" + c.getFName() + " Last Name:" + c.getLName()+ " ID:" + c.getID() + " Phone:" + c.getPhone()  + "\n";
		}
		return list + "\n";
	}
	
	public void sortByName() {
		// we can sort these because our Car objects implement the Comparable Interface & the compareTo method
		Collections.sort(Contact); 
	}
	

	
	public int getSize (){
		return Contact.size();
	}
	
}