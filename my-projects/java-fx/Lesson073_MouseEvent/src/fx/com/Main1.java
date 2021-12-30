/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
		HBox hbox=new HBox(20);
		hbox.getChildren().addAll(b1,b2);
		
		b1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
//				System.out.println("getSceneX():"+event.getSceneX());
//				System.out.println("getSceneY():"+event.getSceneY());
//				
//				System.out.println("getX():"+event.getX());
//				System.out.println("getY():"+event.getY());//button内部坐标
				
//				System.out.println("getSource():"+event.getSource());
//				System.out.println("getTarget():"+event.getTarget());//button或者text
//				System.out.println("getEventType():"+event.getEventType());
//				System.out.println("getButton():"+event.getButton());
//				
//				System.out.println(event.isControlDown());
				
//				System.out.println(event.getClickCount());
				
//				System.out.println(event.isSecondaryButtonDown());
				
				if(event.getClickCount()==2 && event.getButton()==MouseButton.PRIMARY) {
					System.out.println("双击");
				}
			}
		});
		
		b1.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("MousePressed");
			}
		});
		
		b1.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("isSecondaryButtonDown():"+event.isSecondaryButtonDown());
				//触发时检测右键是否处于按下的状态
			}
		});
		
		b1.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("MouseEntered");
			}
		});
		
		b1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("MouseExited");
			}
		});
		
		b2.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("MouseMoved");
			}
		});
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
