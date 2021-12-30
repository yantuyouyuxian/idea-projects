/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
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
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		Button b5=new Button("button5");
		Button b6=new Button("button6");
		
		
		FlowPane fp=new FlowPane();
		fp.setStyle("-fx-background-color:red");
		
		fp.getChildren().addAll(b1,b2,b3,b4,b5,b6);
		
		fp.setPadding(new Insets(10));//内边距
		
//		fp.setMargin(b1, new Insets(10));//子组件外边距
		
		fp.setAlignment(Pos.CENTER);
		
		fp.setHgap(10);
		fp.setVgap(10);//子组件间的水平和垂直间距
		
		fp.setOrientation(Orientation.VERTICAL);
		
		
		Scene scene=new Scene(fp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
