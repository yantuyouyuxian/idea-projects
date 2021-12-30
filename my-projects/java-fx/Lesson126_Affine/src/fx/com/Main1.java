/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Scale;
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
		
		Scale scale=new Scale(1,-1,100,50);
		Affine affine=new Affine(1, 0.8, 0, 0.1, 1, 0);
		//x·ÅËõ£¬y´íÇÐ£¬xÎ»ÒÆ£¬x´íÇÐ£¬y·ÅËõ£¬yÎ»ÒÆ
		
		Button b1=new Button("1---->>>");
		b1.setPrefHeight(100);
		b1.setPrefWidth(100);
		
		Button b2=new Button("button2");
		b2.setStyle("-fx-background-color:yellow");
		b2.setPrefHeight(100);
		b2.setPrefWidth(100);
		b2.setOpacity(0.5);
		b2.getTransforms().addAll(affine);//
		
		
		Button b3=new Button("3---->>>");
		b3.setPrefHeight(100);
		b3.setPrefWidth(100);
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(b1,b2,b3);

		
		AnchorPane.setTopAnchor(b1, 100.0);
		AnchorPane.setLeftAnchor(b1, 100.0);
		
		AnchorPane.setTopAnchor(b2, 100.0);
		AnchorPane.setLeftAnchor(b2, 100.0);
		
		AnchorPane.setTopAnchor(b3, 300.0);
		AnchorPane.setLeftAnchor(b3, 300.0);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

		
		
		System.out.println(b2.getLocalToParentTransform().getTx()+" "+b2.getLocalToParentTransform().getTy());
		
		Bounds bd1=b2.getLayoutBounds();
		System.out.println(bd1);
		
		Bounds bd2=b2.localToParent(bd1);
		System.out.println(bd2);
		
	}

}




