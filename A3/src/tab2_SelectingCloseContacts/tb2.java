package tab2_SelectingCloseContacts;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import application.Contact;
import application.ContactController;
import application.ContactList;


public class tb2 extends Tab
{
   public tb2(ContactController ContactControl, ContactList ContactList)
   {


	   setText("Close Contacts");
	   
	   Label c1name = new Label("First contact");
	   ChoiceBox<Contact> c1 = new ChoiceBox<>();
	  
	   for(int i = 0; i < ContactList.getSize(); i++) { 
		  Contact haha = ContactList.getContact(i);
		   c1.getItems().add(haha);
       }
	   
	   Label c2name = new Label("Second contact");
	   ChoiceBox<String> c2 = new ChoiceBox<>();
	   c2.getItems().add("hello");
	   c2.getItems().add("hello");
	   c2.getItems().add("hello");
	   
	   Label enterDate = new Label("DATE: DD/MM/YYYY");
	   DatePicker eventDatePicker = new DatePicker();
	   Label enterTime = new Label("TIME: 24:60");
	   TextField Time = new TextField ();

	   
	   Button submitButton = new Button("SUBMIT");
	   

	   HBox d1 = new HBox(10);
	    d1.getChildren().addAll(c1name, c1);
	    
	   HBox d2 = new HBox(10);
	    d2.getChildren().addAll(c2name, c2);
	   
	   HBox d3 = new HBox(10);
	    d3.getChildren().addAll(enterDate,eventDatePicker);
	    
	   HBox d4 = new HBox(10);
	    d4.getChildren().addAll(enterTime,Time);
	    
	    HBox d5 = new HBox(10);
	    d5.getChildren().addAll(submitButton);
	    
	   
	    
	   VBox layout = new VBox(10);
	   layout.getChildren().addAll(d1,d2,d3,d4,d5);

	   
	   setContent(layout);
   }
}
