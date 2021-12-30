/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		
		Canvas canvas=new Canvas(800,600);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		
		gc.setFill(Color.ANTIQUEWHITE);
		gc.setStroke(Color.RED);
		gc.setLineWidth(3);
		
		gc.beginPath();
		gc.moveTo(50, 50);
		gc.appendSVGPath("c50,-50,100,50,150,0 s50,50,100,0");
		gc.closePath();
		gc.setLineJoin(StrokeLineJoin.ROUND);
		gc.stroke();
		gc.fill();
		
		gc.moveTo(50, 150);
		gc.quadraticCurveTo(100, 100, 150, 150);
		gc.stroke();
		gc.fill();
		
		
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(canvas);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
