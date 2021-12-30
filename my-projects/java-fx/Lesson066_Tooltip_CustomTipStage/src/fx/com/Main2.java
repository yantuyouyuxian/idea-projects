/**
 * 
 */
package fx.com;

import java.nio.file.attribute.PosixFilePermission;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Z H
 *
 */
public class Main2 extends Application{

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
		AnchorPane an=new AnchorPane();
		Button b1=new Button("button");
		
		Tooltip tip=new Tooltip();
		tip.setPrefHeight(120);
		tip.setPrefWidth(200);
		
		VBox vbox=new VBox();
		vbox.setPrefHeight(60);
		vbox.setPrefWidth(100);
//		vbox.setStyle("-fx-background-color:red");
		
		vbox.setAlignment(Pos.CENTER);
		Button bu=new Button("button");
		bu.setPrefHeight(30);
		bu.setPrefWidth(100);
		
		ImageView iv=new ImageView("images/icon.png");
		iv.setFitWidth(100);
		iv.setFitHeight(100);
		
		vbox.getChildren().addAll(bu,iv);
		Background bg=new Background(new BackgroundFill(Paint.valueOf("blue"), new CornerRadii(10), new Insets(0)));
		vbox.setBackground(bg);
//		tip.setOpacity(0);
		tip.setStyle("-fx-background-color:#ffffff00");
		tip.setGraphic(vbox);
		
		b1.setTooltip(tip);
		an.getChildren().addAll(b1);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
	}

}
