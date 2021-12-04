/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
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
		HBox hbox=new HBox(20);
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		hbox.getChildren().addAll(b1,b2);
		
		
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
		
//		b1.setOnMouseDragged(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println(event.getSceneX()+" "+event.getSceneY());
//			}
//		});
		
		b1.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				b1.startFullDrag();//完整的拖拽动作
				System.out.println("b1 dragDetected");
			}
		});
		
		b1.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 mouseDragOver");
			}
		});
		
		b1.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 mouseDragEntered");
			}
		});
		
		b1.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 mouseDragExited");
			}
		});
		
		b1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b1 mouseDragReleased");
			}
		});
		
		
		
		
		b2.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b2 mouseDragOver");
			}
		});
		
		b2.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b2 mouseDragEntered");
			}
		});
		
		b2.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b2:event.getGestureSource()"+event.getGestureSource());
				System.out.println("b2:event.getsource()"+event.getSource());
				System.out.println("b2:event.getTarget()"+event.getTarget());
				System.out.println("b2 mouseDragExited");
			}
		});
		
		b2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				System.out.println("b2:event.getGestureSource()"+event.getGestureSource());
				System.out.println("b2:event.getsource()"+event.getSource());
				System.out.println("b2:event.getTarget()"+event.getTarget());
				System.out.println("b2 mouseDragReleased");
			}
		});
		
	}

}
