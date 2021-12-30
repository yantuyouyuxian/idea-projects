/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
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
		
		Rotate rotate=new Rotate(45,100,0);//顺时针为正，后两个是旋转中心坐标
		//坐标以组件原始形态计算
		Button b1=new Button("---->>>");
		b1.setPrefHeight(200);
		b1.setPrefWidth(200);
		
		Button b2=new Button("---->>>");
		b2.setStyle("-fx-background-color:yellow");
		b2.setPrefHeight(200);
		b2.setPrefWidth(200);
		b2.getTransforms().addAll(rotate);//
		rotate.setAngle(90);
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(b1,b2);
//		root.setRotate(45);
		
		AnchorPane.setTopAnchor(b1, 200.0);
		AnchorPane.setLeftAnchor(b1, 200.0);
		
		AnchorPane.setTopAnchor(b2, 200.0);
		AnchorPane.setLeftAnchor(b2, 200.0);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

		System.out.println(b2.getLocalToParentTransform().getTx()+" "+b2.getLocalToParentTransform().getTy());
		//跟随旋转改变的组件原点坐标
		
		Bounds bd1=b2.getLayoutBounds();
		System.out.println(bd1);//原始形态的边界
		
		Bounds bd2=b2.localToParent(bd1);
		System.out.println(bd2);//旋转后的边界（矩形包裹）
	}

}




