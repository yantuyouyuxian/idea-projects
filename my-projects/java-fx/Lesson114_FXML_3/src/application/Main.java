package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fl=new FXMLLoader();
		fl.setLocation(fl.getClassLoader().getResource("fxml/main1.fxml"));
		AnchorPane an=(AnchorPane)fl.load();
		
		Scene scene=new Scene(an);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
//		Controller con=(Controller)fl.getController();
//		con.getButton().setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				
//				try {
//					FXMLLoader fl2=new FXMLLoader();
//					fl2.setLocation(fl2.getClassLoader().getResource("fxml/main2.fxml"));
//					AnchorPane an2= (AnchorPane)fl2.load();
//					scene.setRoot(an2);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
