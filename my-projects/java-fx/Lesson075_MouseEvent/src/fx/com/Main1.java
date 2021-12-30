/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
		HBox hbox=new HBox(20);
		hbox.setStyle("-fx-background-color:yellow");
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		
		Circle cir=new Circle(100,Color.RED);
		cir.setPickOnBounds(true);//设置完整边界
		cir.setMouseTransparent(true);//点击cir不会传递给hbox
		
		AnchorPane an=new AnchorPane();
		
		hbox.getChildren().addAll(b1,b2,cir);
		an.getChildren().addAll(hbox);
		
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		b1.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 Pressed");
//				event.setDragDetect(true);
				
				//是否和上次点击位置一致
				System.out.println("b1 isStillSincePress:"+event.isStillSincePress());
			}
		});
		
		b1.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 DragDetected");
			}
		});
		
		cir.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("cir MouseClicked");
			}
		});
		
		hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("hbox onMouseClicked");
				System.out.println("hbox PickResult:"+event.getPickResult());
			}
		});
	}

}
