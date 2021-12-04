/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		
		URL url=fx.getClassLoader().getResource("fxml/myfxml.fxml");
		fx.setLocation(url);
		AnchorPane root1=(AnchorPane)fx.load();
		
		MyController mc=(MyController)fx.getController();
		
		mc.getFxmlbutton().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println(mc.getFxmllabel().getText());
			}
		});//覆盖了controller里的方法
		
		
//		Button bu=(Button)root1.lookup("#fxmlbutton");
		
		
		
		Scene scene=new Scene(root1);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}

}
