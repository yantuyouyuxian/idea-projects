/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
		
//		Circle circle=new Circle(100);
//		circle.setCenterX(100);
//		circle.setCenterY(100);
//		
//		ImageView iv=new ImageView("image/4.jpg");
//		iv.setX(-100);
//		
//		iv.setClip(circle);

		
		Circle c=new Circle(100);
		c.setCenterX(100);
		c.setCenterY(100);
		c.setFill(Color.RED);
		Rectangle rec=new Rectangle(200,100);
		rec.setFill(Color.BLUE);
		rec.setX(100);
		rec.setY(50);
		Shape s1=Shape.intersect(c, rec);//重叠部分,包括边框
		
		Shape s2=Shape.subtract(c, rec);
		
		Shape s3=Shape.union(c, rec);
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(s3);
		
//		AnchorPane.setLeftAnchor(hbox, 100.0);
//		AnchorPane.setTopAnchor(hbox, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
		
		
	}
	

}
