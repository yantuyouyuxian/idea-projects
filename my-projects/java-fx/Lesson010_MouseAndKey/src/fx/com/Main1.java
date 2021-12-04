/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Z H
 *
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

		Button b1 = new Button("b1");

		b1.setPrefHeight(60);
		b1.setPrefWidth(100);

		b1.setLayoutX(100);
		b1.setLayoutY(100);

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("单击b1");
			}
		});

		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				// System.out.println("鼠标单击");

				System.out.println(event.getButton().name());
				if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
					System.out.println("左键双击");
				}
			}
		});// 左键也计入单击
		
		b1.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
//				System.out.println("按下"+event.getCode().getName());
				if(event.getCode().equals(KeyCode.A)) {
					System.out.println("按下A");
				}
			}
		});
		
//		b1.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println("释放"+event.getCode().getName());
//			}
//		});

		Group root = new Group();
		root.getChildren().add(b1);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);

		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
