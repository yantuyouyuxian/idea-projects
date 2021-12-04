/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
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
		
		
		Circle c1=new Circle();
		c1.setCenterX(0);
		c1.setCenterY(0);
		c1.setFill(Color.RED);
		c1.setRadius(100);
		
		Circle c2=new Circle();
		c2.setCenterX(0);
		c2.setCenterY(0);
		c2.setFill(Color.AQUA);
		c2.setRadius(100);
		
		c2.setStroke(Color.BLACK);
		c2.setStrokeWidth(2);
		c2.setSmooth(true);
		c2.getStrokeDashArray().addAll(5.0,5.0);
		
		
		
		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(c1,c2);
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox);
		
		AnchorPane.setLeftAnchor(hbox, 100.0);
		AnchorPane.setTopAnchor(hbox, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
		
		
	}
	

}
