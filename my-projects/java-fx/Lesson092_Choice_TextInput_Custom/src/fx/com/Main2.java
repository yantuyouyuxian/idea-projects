/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main2 extends Application {

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

		Button bu = new Button("点击弹出ChoiceDialog");

		AnchorPane an = new AnchorPane();
		an.getChildren().addAll(bu);
		an.setStyle("-fx-background-color:yellow");

		Scene scene = new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				TextInputDialog in = new TextInputDialog("默认值");
				Button ok=(Button)in.getDialogPane().lookupButton(ButtonType.OK);
				ok.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						System.out.println(in.getEditor().getText());
					}
				});
			}
		});
	}

}
