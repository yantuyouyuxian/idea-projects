package fx.com;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main1 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		
		SplitPane sp=new SplitPane();
		sp.setPrefWidth(800);
//		sp.setPrefHeight(600);
//		sp.setOrientation(Orientation.VERTICAL);
		
		StackPane sp1=new StackPane();
		sp1.getChildren().add(b1);
		
		StackPane sp2=new StackPane();
		sp2.getChildren().add(b2);
		
		StackPane sp3=new StackPane();
		sp3.getChildren().add(b3);
		
		StackPane sp4=new StackPane();
		sp4.getChildren().add(b4);
		
		sp.getItems().addAll(sp1,sp2,sp3,sp4);
		
		sp.setDividerPosition(0, 0.25);
		sp.setDividerPosition(1, 0.5);
		sp.setDividerPosition(2, 0.75);
		
		AnchorPane an=new AnchorPane();
		
		an.getChildren().addAll(sp);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
