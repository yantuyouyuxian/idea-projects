/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
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
public class Main4 extends Application{

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
		
		gc.setGlobalAlpha(0.5);
		gc.setStroke(Color.RED);
		gc.setLineWidth(3);
		
		gc.save();
		
		gc.setEffect(new DropShadow());
		gc.strokeLine(100, 100, 200, 200);
		
		gc.restore();
		gc.strokeLine(100, 250, 200, 250);
		
		
		
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
