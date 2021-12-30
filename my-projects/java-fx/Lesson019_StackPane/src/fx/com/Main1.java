/**
 * 
 */
package fx.com;

import java.util.function.Consumer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *StackPane
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
		
		
		StackPane sp=new StackPane();
		sp.setStyle("-fx-background-color:gray");
		
		sp.getChildren().addAll(b1,b2,b3,b4,b5);
		
		sp.setPadding(new Insets(10));
		
		sp.setAlignment(Pos.BOTTOM_LEFT);
		
		sp.setMargin(b1, new Insets(100));
		
		
		sp.getChildren().forEach(new Consumer<Node>() {

			@Override
			public void accept(Node t) {
				// TODO Auto-generated method stub
				System.out.println(((Button)t).getText());
			}
		});
		
		
		sp.getChildren().forEach((item) ->{
			
		System.out.println(((Button)item).getText());
		});
		
		
		
		Scene scene=new Scene(sp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
