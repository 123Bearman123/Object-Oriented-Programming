package tab1_AddingContacts;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import application.ContactList;
import javafx.geometry.*;

public class AlertBox_Exit {
	
	public static void display(String title, String message) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		
		Button yesButton = new Button("YES");
		yesButton.setOnAction( e->{
			ContactList.saveAllList();
		 	System.exit(0);
		 	
		 });
		
		Button noButton = new Button("NO");
		noButton.setOnAction(e -> System.exit(0));
		
		HBox layout = new HBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		}
	}
