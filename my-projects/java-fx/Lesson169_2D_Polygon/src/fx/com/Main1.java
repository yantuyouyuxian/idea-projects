/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
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
		
		double[] d=new double[] {0,0, 100,0, 100,100};
		Polygon p1=new Polygon(d);
		p1.setFill(Color.RED);
		p1.setStroke(Color.BLACK);
		p1.setStrokeWidth(2);
		p1.getStrokeDashArray().addAll(5.0);
		
		
		Polygon p2=new Polygon();
		p2.getPoints().addAll(0.0,0.0, 50.0,0.0, 100.0,50.0, 100.0,100.0, 0.0,100.0);
		

		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(p1,p2);

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
