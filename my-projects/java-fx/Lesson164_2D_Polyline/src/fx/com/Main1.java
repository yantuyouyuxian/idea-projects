/**
 * 
 */
package fx.com;

import java.util.function.Consumer;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
		
		Polyline p1=new Polyline(0,0, 100,200, 200,0, 0,0);
		p1.setStrokeWidth(5);
		p1.setStroke(Paint.valueOf("red"));
		p1.setFill(Color.BLUE);
		
		Polyline p2=new Polyline();
		p2.getPoints().addAll(0.0,0.0, 100.0,0.0, 0.0,100.0, 100.0,100.0);
		p2.setStrokeWidth(5);
		p2.setStroke(Paint.valueOf("yellow"));
		p2.setFill(Color.RED);
		
		double[] dou=new double[] {0,0, 0,200, 200,200, 0,0};
		Polyline p3=new Polyline(dou);
		p3.setStrokeWidth(5);
		p3.setStroke(Paint.valueOf("blue"));
		p3.setFill(Color.YELLOW);
		p3.setStrokeLineCap(StrokeLineCap.ROUND);
		p3.setStrokeLineJoin(StrokeLineJoin.ROUND);
		
//		p3.setStrokeMiterLimit(0);
//		p3.setStrokeType(StrokeType.CENTERED);
		p3.getStrokeDashArray().addAll(5.0,10.0);
		p3.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("P3");
				//不填充颜色，点击内部无效
			}
		});
		
		
		HBox hbox=new HBox();
		hbox.getChildren().addAll(p1,p2,p3);
		
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
