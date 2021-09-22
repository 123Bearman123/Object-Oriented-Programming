package application;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Contact implements Serializable, Comparable<Contact> {
	private String fname;
	private String lname;
	private int id;
	private int phone;
	
	public Contact (String f, String l, int i, int p){
		// constructor
		fname = f;
		lname = l;
		id = i;
		phone = p;
	}

	public Contact(){} // a second constructor

	public String getFName() {
		return fname;
	}
	
	//@XmlElement
	public void setFName(String f ){
		fname = f;
	}
	
	public String getLName() {
		return lname;
	}
	
	//@XmlElement
	public void setLName(String l ){
		fname = l;
	}
	
	public int getID() {
		return id;
	}
	
	//@XmlElement
	public void setID(int i ){
		id= i;
	}
	
	public int getPhone() {
		return phone;
	}
	
	//@XmlElement
	public void setPhone(int p ){
		phone= p;
	}

	public String toString ()
	 {
       String s = "I am a person of name " + fname + " " + lname + " "
    		   + "with the id " + id + " and phone number " + phone +"\n";
	   return s;
	 }

	public int compareTo(Contact n){
		// we compare to another car
	
	   int lastCmp = this.fname.compareTo(n.getFName()); // String compare to 
	   if (lastCmp != 0)
		  
		   return lastCmp;
	   else
		   // if the makes are the same then compare the models next
	       return  lname.compareTo(n.getLName()); // String compare to 
	   
	}
	
}
