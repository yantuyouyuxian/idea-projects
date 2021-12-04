/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *Hyperlink
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
		
		VBox vb=new VBox();
		
		Hyperlink link=new Hyperlink("www.baidu.com");
		
		link.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				HostServices host=Main1.this.getHostServices();
				
				host.showDocument(link.getText());
			}
		});
		
		vb.getChildren().add(link);
		
		Scene scene=new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
