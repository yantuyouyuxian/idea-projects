/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Z H
 *宽高，坐标和边界
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
		AnchorPane an=new AnchorPane();
		an.setStyle("-fx-background-color:gray");
		
		Button b1=new Button("b1");
		
		Rectangle rec=new Rectangle();
		rec.setHeight(50);
		rec.setWidth(50);
		
		HBox hbox =new HBox();
		hbox.setStyle("-fx-background-color:red");
		hbox.setPrefWidth(300);
		hbox.setPrefHeight(300);
		hbox.getChildren().addAll(b1,rec);
		
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		System.out.println(b1.getContentBias());
		
	}

}
