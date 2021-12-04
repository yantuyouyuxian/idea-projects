/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *宽高，坐标和边界
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
		AnchorPane an=new AnchorPane();
		
		Button b1=new Button("button1");
		b1.setEffect(new DropShadow());
		b1.setRotate(90);
		
		an.getChildren().addAll(b1);
		AnchorPane.setTopAnchor(b1, 100.0);
		AnchorPane.setLeftAnchor(b1, 100.0);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		System.out.println(b1.getLayoutBounds());//不带任何效果
		System.out.println(b1.getBoundsInLocal());//包含效果
		System.out.println(b1.getBoundsInParent());//包含旋转
		
	}

}
