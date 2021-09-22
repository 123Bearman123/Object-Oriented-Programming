package tab3_FindingCloseContacts;

import application.ContactController;
import application.ContactList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class tb3 extends Tab
{ 
   public tb3(ContactController ContactControl, ContactList ContactList)
   {
	   setText("Positive");
	   
	   Label p1name = new Label("Select a contact");
	   ChoiceBox<String> p1 = new ChoiceBox<>();
	   p1.getItems().add("hello");
	   p1.getItems().add("hello");
	   p1.getItems().add("hello");
	   TextArea positiveAll = new TextArea("Others in risk of having the virus");
	   
	   Button findNameButton = new Button("FIND BY NAME");
	   findNameButton.setOnAction( e->{
		   ContactList.sortByName();
			positiveAll.setText("In name order\n" + ContactList.listAllContacts());
		 }); 
	   
	   Button findDateButton = new Button("FIND BY DATE");
	   
	   
	   
	   
	   HBox f1 = new HBox(10);
	    f1.getChildren().addAll(p1name, p1);
	    
	   HBox f2 = new HBox(10);
	    f2.getChildren().addAll(findNameButton,findDateButton);
	   
	   HBox f3 = new HBox(10);
	    f3.getChildren().addAll(positiveAll);
	    
	   VBox layout = new VBox(10);
		   layout.getChildren().addAll(f1,f2,f3);

		   
		setContent(layout);
   }
}
