/**
 * 
 */
package fx.com;

import java.util.function.Consumer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
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
		an1.setStyle("-fx-background-color:yellow");
		Path path=new Path();
		MoveTo mt=new MoveTo(0,0);
		
		LineTo lt=new LineTo(100,0);
		
		QuadCurveTo qc=new QuadCurveTo(50, 0, 100, 100);
		qc.setAbsolute(false);
	
		HLineTo ht=new HLineTo(100);
		ht.setAbsolute(false);
		
		CubicCurveTo ct=new CubicCurveTo(50,-50, 100,50, 150,0);
		ct.setAbsolute(false);
		
		VLineTo vt=new VLineTo(100);
		vt.setAbsolute(false);
		
		ArcTo at=new ArcTo(100, 50, 0, 100, 100, true, true);
		at.setAbsolute(false);
		
		ClosePath cp=new ClosePath();
		
		path.getElements().addAll(mt,lt,qc,ht,ct,vt,at,cp);
		
		path.setFill(Color.ANTIQUEWHITE);
		path.setStroke(Color.BLACK);
		path.setStrokeWidth(2);
//		path.setStrokeLineCap(value);
//		path.setStrokeLineJoin(value);
//		path.getStrokeDashArray().addAll(c);
		
		an1.getChildren().add(path);
		
		HBox hbox=new HBox(30);
		hbox.getChildren().addAll(an1);

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
