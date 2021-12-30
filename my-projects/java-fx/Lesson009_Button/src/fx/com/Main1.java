/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Z H Button
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

		Button b1 = new Button("按钮");
		b1.setPrefHeight(60);
		b1.setPrefWidth(100);
		b1.setLayoutX(100);
		b1.setLayoutY(100);
		
		b1.setFont(Font.font("sans-serif", 20));

		b1.setTextFill(Paint.valueOf("#CD0000"));
		
		Button b2=new Button("b2");
		b2.setPrefHeight(60);
		b2.setPrefWidth(100);
		b2.setLayoutX(300);
		b2.setLayoutY(100);

//		BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F50"), new CornerRadii(20),
//				new Insets(5, 10, 15, 20));//颜色后面两个数字代表透明度
//		Background bg = new Background(bgf);
//		b1.setBackground(bg);
//
//		BorderStroke bos = new BorderStroke(Paint.valueOf("#8A28E2"), BorderStrokeStyle.SOLID, new CornerRadii(20),
//				new BorderWidths(5));
//		Border border = new Border(bos);
//		b1.setBorder(border);
		
		b1.setStyle(
				"-fx-background-color:#7ccd7c;"+
				"-fx-background-radius:20;"+
				"-fx-text-fill:#5cacee;"
		);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				System.out.println("单击了"+((Button)event.getSource()).getText());
			}
		});
		
		
		
		Group root = new Group();
		root.getChildren().add(b1);
		root.getChildren().add(b2);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);

		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

	}

}
