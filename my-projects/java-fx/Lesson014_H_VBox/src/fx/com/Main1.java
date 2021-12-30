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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Z H
 * H,VBox
 */
public class Main1 extends Application {

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

		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		
		AnchorPane ap=new AnchorPane();
		ap.setStyle("-fx-background-color:gray");
		
		
		
		HBox hb=new HBox();//水平
		hb.setStyle("-fx-background-color:pink");
		hb.setPrefHeight(300);
		hb.setPrefWidth(500);
		hb.getChildren().addAll(b1,b2);
//		ap.setLeftAnchor(hb, 100.0);
		
		hb.setPadding(new Insets(10));//内边距，与子控件的边距
		
		hb.setSpacing(10);//子组件的间距
		
		hb.setMargin(b1, new Insets(50));//h1里b1的外边距
		
		hb.setAlignment(Pos.CENTER);
		
		
		ap.getChildren().add(hb);

		
//		VBox vb=new VBox();//垂直
//		vb.setStyle("-fx-background-color:blue");
//		vb.setPrefHeight(300);
//		vb.setPrefWidth(100);
//		vb.getChildren().addAll(b3,b4);
//		ap.getChildren().add(vb);
		
		
		Scene scene=new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
