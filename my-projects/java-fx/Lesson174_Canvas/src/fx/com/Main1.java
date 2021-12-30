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
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
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
		
		Canvas canvas=new Canvas(800,600);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		
		gc.setFill(Color.ANTIQUEWHITE);//œ»…Ë÷√—’…´
		gc.setStroke(Color.AQUA);
		gc.setLineWidth(5);
		
		gc.fillRect(100, 100, 100, 100);
		gc.strokeRect(200, 200, 100, 100);
		
		gc.setStroke(Color.CHARTREUSE);
		gc.strokeLine(50, 400, 300, 400);
		
		gc.setFill(Color.AQUAMARINE);
		gc.fillPolygon(new double[] {400,500,600}, new double[] {400,100,400}, 3);
		
		gc.setFill(Color.BLUE);
		gc.setFont(Font.font(30));
		gc.fillText("hello world", 100, 50, 200);
		
//		gc.rotate(degrees);
		gc.setLineWidth(3);
		gc.setStroke(Color.BLACK);
		gc.strokeText("stroketext", 300, 50);
		
		gc.clearRect(100, 100, 50, 50);
		
		
		
		
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
