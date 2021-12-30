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
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
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
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
		HBox hbox1=new HBox(30);
		Button b1=new Button("button1");
		b1.setPrefWidth(200);
		b1.setPrefHeight(200);
		ImageView iv1=new ImageView("image/tou.jpg");
		iv1.setFitWidth(500);
		iv1.setPreserveRatio(true);
		hbox1.getChildren().addAll(b1,iv1);
		
		
		HBox hbox2=new HBox(30);
		Button b2=new Button("button2");
		b2.setPrefWidth(200);
		b2.setPrefHeight(200);
		ImageView iv2=new ImageView("image/tou.jpg");
		iv2.setFitWidth(500);
		iv2.setPreserveRatio(true);
		hbox2.getChildren().addAll(b2,iv2);
//		hbox2.setTranslateY(50);
	
		hbox2.setEffect(getEffect());
		StackPane sp=new StackPane();
		
		sp.getChildren().addAll(hbox1,hbox2);

		AnchorPane an=new AnchorPane();
		an.getChildren().add(sp);
		
		Scene scene = new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
	}
	
	public Effect getEffect() {
	
		Blend blend=new Blend();
		blend.setOpacity(1);
		blend.setMode(BlendMode.ADD);
		
		return blend;
	}
	

}
