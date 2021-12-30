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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Z H
 *
 */
public class Main3 extends Application {

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

		Button bu = new Button("点击弹出自定义弹窗");

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
				AnchorPane an = new AnchorPane();
				
				Stage stage=new Stage();
				
				stage.initOwner(primaryStage);
				stage.initModality(Modality.WINDOW_MODAL);//不关闭无法操作owner窗口
				
				stage.initStyle(StageStyle.UTILITY);
				stage.setAlwaysOnTop(true);
				
				Scene scene = new Scene(an);
				stage.setScene(scene);
				stage.setWidth(300);
				stage.setHeight(180);
				stage.setTitle("CustomStage");
				stage.show();
			}
		});
	}

}
