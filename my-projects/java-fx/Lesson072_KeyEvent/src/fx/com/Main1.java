/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{
	int isA5=0;
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
		
		Button b1=new Button("b1");
		
		Button b2=new Button("b1");
		
		TextField tf=new TextField();
		
		Rectangle rec=new Rectangle(100,100);
		rec.setFill(Color.RED);
		
		hbox.getChildren().addAll(b1,b2,tf,rec);
		
//		b1.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				// TODO Auto-generated method stub
////				System.out.println("getCharacter():"+event.getCharacter());
////				System.out.println("getCode():"+event.getCode());
////				System.out.println("getEventType():"+event.getEventType());
////				System.out.println("getSource():"+event.getSource());
////				System.out.println("getTarget():"+event.getTarget());
////				System.out.println("getText():"+event.getText());
//				if(event.getCode().equals(KeyCode.A)) {
//					if(isA5<5) {
//						System.out.println("A");
//						isA5+=1;
//					}
//				}
//				
//			}
//		});
//		b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println("released:"+event.getCode().getName());
//				isA5=0;
//			}
//		});
		
		tf.setOnKeyTyped(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
//				System.out.println(event.getCode().getName());
				System.out.println(event.getCharacter());
			}
		});
		
		rec.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				System.out.println("rec:"+event.getCode().getName());
			}
		});
		
		rec.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				rec.requestFocus();
			}
		});
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
