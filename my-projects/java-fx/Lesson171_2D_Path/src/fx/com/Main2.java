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
import javafx.scene.shape.FillRule;
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
		AnchorPane an1=new AnchorPane();
		an1.setStyle("-fx-background-color:yellow");
		Path path=new Path();
		MoveTo mt1=new MoveTo(0,0);
		
		HLineTo ht1=new HLineTo(100);
		ht1.setAbsolute(false);
		VLineTo vt1=new VLineTo(100);
		vt1.setAbsolute(false);
		
		HLineTo ht2=new HLineTo(-100);
		ht2.setAbsolute(false);
		VLineTo vt2=new VLineTo(-100);
		vt2.setAbsolute(false);
		
		MoveTo mt2=new MoveTo(50,50);
		
		path.getElements().addAll(mt1,ht1,vt1,ht2,vt2,mt2,ht1,vt1,ht2,vt2);
		
		path.setFill(Color.ANTIQUEWHITE);
		path.setStroke(Color.BLACK);
		path.setStrokeWidth(2);
		path.setFillRule(FillRule.EVEN_ODD);
		
		
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
