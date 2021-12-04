/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *BorderPane
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
		
		
		
		AnchorPane ap1=new AnchorPane();
//		ap1.setPrefWidth(100);
		ap1.setPrefHeight(60);
		ap1.setStyle("-fx-background-color:red");
		
		
		AnchorPane ap2=new AnchorPane();
//		ap2.setPrefWidth(100);
		ap2.setPrefHeight(60);
		ap2.setStyle("-fx-background-color:yellow");
		
		
		AnchorPane ap3=new AnchorPane();
		ap3.setPrefWidth(100);
//		ap3.setPrefHeight(60);
		ap3.setStyle("-fx-background-color:blue");
		
		
		AnchorPane ap4=new AnchorPane();
		ap4.setPrefWidth(100);
//		ap4.setPrefHeight(60);
		ap4.setStyle("-fx-background-color:pink");
		
		
		AnchorPane ap5=new AnchorPane();
//		ap5.setPrefWidth(60);
//		ap5.setPrefHeight(60);
		ap5.setStyle("-fx-background-color:green");
		
		BorderPane bor=new BorderPane();//
		bor.setStyle("-fx-background-color:gray");
		
		
		
		bor.setTop(ap1);
		bor.setBottom(ap2);
		bor.setLeft(ap3);
		bor.setRight(ap4);
		bor.setCenter(ap5);//������ֻἷռ��䣬���¸߶�Ϊ�������ҿ��Ϊ��
		
		
		bor.setPadding(new Insets(20));//�ڱ߾�
		
		bor.setMargin(ap5, new Insets(10));//���������߾�
		
		Button b1=new Button("b1");
		bor.setTop(b1);
		bor.setAlignment(b1, Pos.CENTER);//������Ķ��뷽ʽ
		
		
		Scene scene=new Scene(bor);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
