package tab1_AddingContacts;

import java.io.IOException;

import application.AlertBox;
import application.ContactController;
import application.ContactList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class tb1 extends Tab
{
   @SuppressWarnings("static-access")
public tb1(ContactController ContactControl, ContactList ContactList) throws IOException
   {
     // setBackground (Color.green);
	   setText("Add Contacts");


	   	 Label contacts = new Label("      ----------Contacts----------");	 
		 Label enterFirstName = new Label("Enter First Name");
		 TextField FirstName = new TextField ();
		 Label enterLastName = new Label("Enter Last Name");
		 TextField LastName = new TextField ();
		 Label enterUniqueID = new Label("Enter Unique ID");
		 TextField UniqueID = new TextField ();
		 Label enterPhoneNo = new Label("Enter Phone Number");
		 TextField PhoneNo = new TextField ();
		 Button addButton = new Button("ADD");
		 Button removeButton = new Button("REMOVE");
		 Button listButton = new Button("LIST");
		 TextArea peopleAll = new TextArea("People in the Application");
		 Button loadButton = new Button("LOAD");
		 Button saveButton = new Button("SAVE");
		 Button infoButton = new Button("INFO");
		 Button exitButton = new Button("EXIT");
		 exitButton.setTranslateX(440);
		 
		 addButton.setOnAction( e->{
		 	ContactControl.addContactToList(FirstName.getText(), LastName.getText(), UniqueID.getText(), PhoneNo.getText());
		 }); 
		 
		 removeButton.setOnAction( e->
		 	ContactControl.remContactByName(FirstName.getText(), LastName.getText(), 
		 			UniqueID.getText(), PhoneNo.getText())
		 );
		 
		 listButton.setOnAction(new EventHandler<ActionEvent>() {
		 @Override
		 public void handle(ActionEvent event) {
			 	String allCar=ContactControl.getListContact();
		        peopleAll.setText(allCar);

		 	}
		 });
		 
		 loadButton.setOnAction( e->{
			 ContactList.loadAllList();
		 });
		 
		 saveButton.setOnAction( e->{
		 	ContactList.saveAllList();
		 });
		 
		 exitButton.setOnAction(e -> AlertBox_Exit.display("Contact List", "Do you want to save"));
		 
		 infoButton.setOnAction(e -> AlertBox.display("Contact"," This is where you add a contact. \n Please complete all fields \n with the appropiate data."));
		 
		 HBox r0 = new HBox(10);
		    r0.getChildren().addAll(contacts);
		 
		 HBox r1 = new HBox(10);
		    r1.getChildren().addAll(enterFirstName,FirstName);
		    
		 HBox r2 = new HBox(10);
		    r2.getChildren().addAll(enterLastName,LastName);
		    
		 HBox r3 = new HBox(10);
		    r3.getChildren().addAll(enterUniqueID,UniqueID);
		    
		 HBox r4 = new HBox(10);
			r4.getChildren().addAll(enterPhoneNo,PhoneNo);
			    
	     HBox r5 = new HBox(10);
			r5.getChildren().addAll(addButton,removeButton,listButton);
			    
		 HBox r6 = new HBox(10);
			r6.getChildren().addAll(peopleAll);
			 
	     HBox r7 = new HBox(10);
			r7.getChildren().addAll(loadButton,saveButton,infoButton, exitButton);
		    
		 VBox v1 = new VBox (10);
		   v1.getChildren().addAll(r0,r1,r2,r3,r4,r5,r6,r7);

      setContent(v1);
   }
}
