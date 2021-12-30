/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fx=new FXMLLoader();
		
//		AnchorPane root=fx.load(new FileInputStream(new File()));
		
		URL url=fx.getClassLoader().getResource("fxml/myfxml.fxml");
		fx.setLocation(url);
		AnchorPane root1=(AnchorPane)fx.load();
		Button bu=(Button)root1.lookup("#fxmlbutton");
		
		
		AnchorPane an=new AnchorPane();
		Button button =new Button();
		button.setId("b1");
		button.setPrefWidth(100);
		button.setPrefHeight(100);
		AnchorPane.setTopAnchor(button, 100.0);
		AnchorPane.setLeftAnchor(button, 100.0);
		an.getChildren().add(button);
		Button b=(Button)an.lookup("#b1");
		System.out.println(b.getText());
		
		
		
		Scene scene=new Scene(root1);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}

}
