/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * @author Z H
 *TilePane
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
		
		Button b1=new Button("button1");
		b1.setPrefHeight(50);
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		Button b5=new Button("button5");
		Button b6=new Button("button6");
		Button b7=new Button("button7");
		Button b8=new Button("button8");
		
		TilePane tile=new TilePane();
		tile.setStyle("-fx-background-color:blue");
		
		tile.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8);
		
		tile.setHgap(10);
		tile.setVgap(10);
		
		tile.setPadding(new Insets(50));
		
//		tile.setAlignment(Pos.CENTER);
		
		tile.setMargin(b1, new Insets(50));
		
		tile.setAlignment(b2, Pos.BOTTOM_RIGHT);
		
		
		Scene scene=new Scene(tile);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	
	}

}
