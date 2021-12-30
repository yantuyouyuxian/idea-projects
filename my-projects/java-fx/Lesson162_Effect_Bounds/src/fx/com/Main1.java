/**
 * 
 */
package fx.com;

import java.util.function.Consumer;



import javafx.application.Application;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
		Rectangle rec=new Rectangle();
		rec.setFill(Color.BLUE);
		
		rec.setWidth(100);
		rec.setHeight(100);
		
		DropShadow ds=new DropShadow();
		ds.setRadius(20);
		
		GaussianBlur gb=new GaussianBlur();
		gb.setRadius(3);
		ds.setInput(gb);
		
		rec.setEffect(ds);
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(rec);
		
		AnchorPane.setTopAnchor(rec, 100.0);
		AnchorPane.setLeftAnchor(rec, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
		
		System.out.println(rec.getWidth()+" "+rec.getHeight());
		
		System.out.println(rec.getLayoutBounds());//
		
		System.out.println(rec.getBoundsInLocal());//��Ч��
		
		System.out.println(rec.getBoundsInParent());
		
	
		
	}
	
	
	

}
