package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tab1_AddingContacts.tb1;
import tab2_SelectingCloseContacts.tb2;
import tab3_FindingCloseContacts.tb3;


public class Main extends Application {
	 
	@Override
	public void start(Stage primaryStage) {
		try {
			ContactController ContactControl= new ContactController();
			ContactList ContactList= new ContactList();
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,600,300);
			
		      TabPane tp = new TabPane();
		      tp.getTabs().add (new tb1(ContactControl,ContactList));
		      tp.getTabs().add (new tb2(ContactControl,ContactList));
		      tp.getTabs().add (new tb3(ContactControl,ContactList));
              			
			  mainPane.setCenter(tp);
			  
		      mainPane.prefHeightProperty().bind(scene.heightProperty());
		      mainPane.prefWidthProperty().bind(scene.widthProperty());
		      
		      root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	
}
