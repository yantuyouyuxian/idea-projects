/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
		
		System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
		
		AnchorPane root = new AnchorPane();
		root.setStyle("-fx-background-color:#ffffff00");
		
		Button b1=new Button("button1");
		b1.setTranslateZ(0);
		
		Button b2=new Button("button3");
		b2.setTranslateZ(200);
		
		Button b3=new Button("button3");
		b3.setTranslateZ(400);

		Button b4=new Button("button3");
		b4.setTranslateZ(50);
		b4.setDepthTest(DepthTest.DISABLE);
		
		root.setDepthTest(DepthTest.ENABLE);//disable,可以点击
		
		
		root.getChildren().addAll(b1,b2,b3,b4);
		
		
//		Scene scene = new Scene(root);
		Scene scene = new Scene(root,1000,600,true);
		
		scene.setCamera(new PerspectiveCamera());//有相机才能看到
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}
	

}
