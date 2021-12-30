/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
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
		AnchorPane an=new AnchorPane();
//		an.setStyle("-fx-background-color:gray");
		
		Button b1=new Button("button1");
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color:yellow");
		hbox.setPrefHeight(300);
		hbox.setPrefWidth(300);
		hbox.getChildren().addAll(b1);
		hbox.setAlignment(Pos.CENTER);
		
		an.getChildren().addAll(hbox);
		
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		System.out.println("b1(x,y)  "+b1.getLayoutX()+"  "+b1.getLayoutY());
		
		Bounds bounds=b1.getLayoutBounds();//
		System.out.println("getLayoutBounds()");
		System.out.println(bounds.getMinX()+"  "+bounds.getMinY());
		System.out.println(bounds.getMaxX()+"  "+bounds.getMaxY());
		System.out.println();
		
		Point2D point1=b1.localToParent(bounds.getMinX(),bounds.getMinY());
		System.out.println(point1.getX()+" "+point1.getY());
		
		Point2D point2=b1.localToScene(bounds.getMinX(),bounds.getMinY());
		System.out.println(point2.getX()+" "+point2.getY());
		
		Point2D point3=b1.localToScreen(bounds.getMinX(),bounds.getMinY());
		System.out.println(point3.getX()+" "+point3.getY());
		
		Point2D point4=b1.parentToLocal(point1.getX(), point1.getY());
		System.out.println(point4.getX()+" "+point4.getY());
		//sceneToLocal();
		
		Bounds bounds2=b1.getBoundsInLocal();//
		System.out.println("getBoundsInLocal()");
		System.out.println(bounds2.getMinX()+"  "+bounds2.getMinY());
		System.out.println(bounds2.getMaxX()+"  "+bounds2.getMaxY());
		
	
	}

}
