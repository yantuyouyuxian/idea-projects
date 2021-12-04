/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
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
	
		Text text=new Text("text hello");
		
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
		
		b1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 mouseClicked");
				MouseEvent me=event.copyFor(b2, b2);
				System.out.println("me eventType:"+me.getEventType());
				Event.fireEvent(me.getTarget(), me);
			}
		});
		
		b2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b2 mouseClicked");
			}
		});
		
		text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println(event.getTarget());
			}
		});
	}

}
