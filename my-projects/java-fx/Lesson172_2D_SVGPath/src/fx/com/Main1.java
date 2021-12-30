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
import javafx.scene.shape.SVGPath;
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
		
		SVGPath path1=new SVGPath();
		path1.setContent("m0,0 l100,100 v100 h-100 z");
		path1.setFill(Color.ANTIQUEWHITE);
		path1.setStroke(Color.BLACK);
		
		
		SVGPath path2=new SVGPath();
		path2.setContent("m0,0 c50,-50,100,50,150,0 s50,50,100,0");//三次
		path2.setFill(Color.ANTIQUEWHITE);
		path2.setStroke(Color.BLACK);
		
		SVGPath path3=new SVGPath();
		path3.setContent("m0,0 q50,-50,100,0 t100,0");//二次
		path3.setFill(Color.ANTIQUEWHITE);
		path3.setStroke(Color.BLACK);
		
		SVGPath path4=new SVGPath();
		path4.setContent("m0,0 a100,50,0,1,1,50,50");//椭圆
		path4.setFill(Color.ANTIQUEWHITE);
		path4.setStroke(Color.BLACK);
		
		
		
		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(path1,path2,path3,path4);

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
