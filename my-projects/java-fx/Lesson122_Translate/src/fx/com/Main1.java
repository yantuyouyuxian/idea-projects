/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
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
	
		Translate tl1=new Translate(100,100);
		Translate tl2=new Translate(100,100);
		
		System.out.println(tl1.clone());
		System.out.println(tl1.createInverse());
		System.out.println(tl1.transform(110, 111));
		System.out.println(tl1.deltaTransform(221, 222));//生成一个为参数的点
		System.out.println(tl1.inverseDeltaTransform(332, 333));//貌似和上面一样
		
		Button b1=new Button("button1");
		b1.setPrefHeight(100);
		b1.setPrefWidth(100);
		b1.setLayoutX(100);
		b1.setLayoutY(100);
//		b2.setTranslateX(100);
		
		Button b2=new Button("button2");
		b2.setPrefHeight(100);
		b2.setPrefWidth(100);
		b2.setLayoutX(100);
		b2.setLayoutY(100);
		b2.getTransforms().addAll(tl1,tl2);
	
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(b1,b2);
		an.setPrefWidth(600);
		an.setPrefHeight(600);
		an.setStyle("-fx-background-color:yellow");
		
		AnchorPane root=new AnchorPane();
		root.getChildren().add(an);
		AnchorPane.setTopAnchor(an, 100.0);
		AnchorPane.setLeftAnchor(an, 100.0);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		

		System.out.println(b2.getLayoutX()+" "+b2.getLayoutY());
		
//		System.out.println(b2.getTranslateX()+" "+b2.getTranslateY());
		
		System.out.println(b2.getLocalToParentTransform().getTx()+" "+b2.getLocalToParentTransform().getTy());
	
		System.out.println(b2.getLocalToSceneTransform().getTx()+" "+b2.getLocalToSceneTransform().getTy());
	
		Bounds bd=b2.getLayoutBounds();
		Bounds bd2=b2.localToParent(bd);
		System.out.println(bd+"\n"+bd2);
		
	}

}




