/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
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

		Group root = new Group();

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);

		TextField text = new TextField();
		// text.setText("textfield");

		text.setLayoutX(100);
		text.setLayoutY(50);

		text.setPrefHeight(50);
		text.setPrefWidth(200);

		text.setFont(Font.font(20));

		Tooltip tip = new Tooltip("提示");
		tip.setFont(Font.font(25));
		text.setTooltip(tip);// 提示
		text.setPromptText("input password");
		text.setFocusTraversable(false);// 取消焦点

		text.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
				if (newValue.length() > 7) {
					text.setText(oldValue);
				}
			}
		});
		
		text.selectedTextProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		text.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("text.setOnAction()");
			}
		});//回车事件，不是单击
		
		text.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("text.setOnMouseClicked()");
			}
		});
		

		PasswordField pwf=new PasswordField();
		pwf.setPrefWidth(200);
		pwf.setPrefHeight(50);
		
		pwf.setLayoutX(100);
		pwf.setLayoutY(150);
		
		pwf.setFont(Font.font(20));
		
		pwf.setFocusTraversable(false);
		
		
		
		Label lab=new Label("label");
		lab.setFont(Font.font(20));
		lab.setLayoutX(100);
		lab.setLayoutY(250);
		lab.setOpacity(0.5);
		lab.setTextFill(Paint.valueOf("red"));
		lab.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("lab.setOnMouseClicked()");
			}
		});
		
		
		root.getChildren().add(text);
		root.getChildren().add(pwf);
		root.getChildren().add(lab);
		primaryStage.show();
	}

}
