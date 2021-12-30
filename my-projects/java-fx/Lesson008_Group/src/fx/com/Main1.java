/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Z H Group容器的使用
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
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");

		b1.setPrefHeight(30);
		b1.setPrefWidth(50);
		b1.setLayoutX(0);
		b1.setLayoutY(10);

		b2.setPrefHeight(30);
		b2.setPrefWidth(50);
		b2.setLayoutX(200);
		b2.setLayoutY(10);

		b3.setPrefHeight(30);
		b3.setPrefWidth(50);
		b3.setLayoutX(400);
		b3.setLayoutY(10);

		Group group = new Group();

		group.getChildren().addAll(b1, b2, b3);

		group.getChildren().addListener(new ListChangeListener<Node>() {

			@Override
			public void onChanged(Change<? extends Node> c) {
				// TODO Auto-generated method stub
				System.out.println("group组件数量" + c.getList().size());
			}

		});

		Object[] obj = group.getChildren().toArray();

		System.out.println(obj.length);

		for (Object o : obj) {
			Button bu = (Button) o;
			bu.setPrefHeight(100);
		}

		b1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Button b4 = new Button("b4");
				b4.setPrefHeight(30);
				b4.setPrefWidth(50);
				b4.setLayoutX(200);
				b4.setLayoutY(group.getChildren().size() * 50);
				group.getChildren().add(b4);
			}
		});
		// System.out.println(group.contains(0,20));//只检测node的坐标位置，不考虑node范围

		// group.setOpacity(0.5);
		// group.setAutoSizeChildren(false);//group默认自动调整childrennode大小
		// group.getChildren().remove(0);
		// group.getChildren().clear();

		Scene scene = new Scene(group);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(300);
		primaryStage.setWidth(500);
		primaryStage.show();

	}

}
