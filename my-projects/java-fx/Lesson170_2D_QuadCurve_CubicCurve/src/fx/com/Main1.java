/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
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
		
		AnchorPane an1=new AnchorPane();
		QuadCurve q1=new QuadCurve();
		q1.setFill(Color.ALICEBLUE);
		q1.setStroke(Color.BLACK);
		q1.setStrokeWidth(2);
		q1.setStartX(0);
		q1.setStartY(100);
		
		q1.setControlX(100);
		q1.setControlY(0);
		
		q1.setEndX(200);
		q1.setEndY(100);
		an1.getChildren().add(q1);
		an1.setStyle("-fx-background-color:yellow");
		
		AnchorPane an2=new AnchorPane();
		CubicCurve c1=new CubicCurve();
		c1.setFill(Color.ALICEBLUE);
		c1.setStroke(Color.BLACK);
		c1.setStrokeWidth(2);
		c1.setStartX(0);
		c1.setStartY(100);
		
		c1.setControlX1(100);
		c1.setControlY1(0);
		
		c1.setControlX2(200);
		c1.setControlY2(200);
		
		c1.setEndX(300);
		c1.setEndY(100);
		an2.getChildren().add(c1);
		an2.setStyle("-fx-background-color:yellow");

		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(an1,an2);

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
