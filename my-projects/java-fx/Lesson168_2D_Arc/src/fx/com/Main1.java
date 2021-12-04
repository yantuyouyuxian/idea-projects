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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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
		Arc a1=new Arc();//极坐标计算角度
		a1.setCenterX(0);
		a1.setCenterY(0);
		a1.setRadiusX(100);
		a1.setRadiusY(100);
		a1.setLength(135);
//		a1.setStartAngle(45);
		a1.setFill(Color.RED);
		a1.setType(ArcType.OPEN);
		a1.setStroke(Color.BLACK);
		a1.setStrokeWidth(3);
		
		Arc a2=new Arc();//极坐标计算角度
		a2.setCenterX(0);
		a2.setCenterY(0);
		a2.setRadiusX(100);
		a2.setRadiusY(100);
		a2.setLength(135);
//		a1.setStartAngle(45);
		a2.setFill(Color.RED);
		a2.setType(ArcType.CHORD);
		a2.setStroke(Color.BLACK);
		a2.setStrokeWidth(3);
		
		Arc a3=new Arc();//极坐标计算角度
		a3.setCenterX(0);
		a3.setCenterY(0);
		a3.setRadiusX(100);
		a3.setRadiusY(100);
		a3.setLength(135);
//		a1.setStartAngle(45);
		a3.setFill(Color.RED);
		a3.setType(ArcType.ROUND);
		a3.setStroke(Color.BLACK);
		a3.setStrokeWidth(3);
		a3.getStrokeDashArray().addAll(5.0);
		
		
		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(a1,a2,a3);
		
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
