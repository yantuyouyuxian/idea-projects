package fx.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main1 extends Application {
	
	static boolean isManged=false;
	static boolean isVisable=false;
	static double opacityValue=0;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		Button b3 = new Button("button3");
		Button b4 = new Button("button4");

		Button b5 = new Button("b3.setManaged(false)");
		Button b6 = new Button("b3.setVisible(false)");
		Button b7 = new Button("b3.setOpacity(0)");

		// b3.setManaged(false);
		// b3.setVisible(false);
		// b3.setOpacity(0);

		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color:gray");

		HBox hbox = new HBox();
		hbox.getChildren().addAll(b1, b2, b3, b4);
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color:blue");

		VBox vbox = new VBox();
		vbox.getChildren().addAll(b5, b6, b7);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(10);
		vbox.setStyle("-fx-background-color:pink");

		ap.setTopAnchor(vbox, 100.0);

		ap.getChildren().addAll(hbox, vbox);
		Scene scene = new Scene(ap);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		b5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				b3.setManaged(isManged);
				new Print(hbox);
				isManged=!isManged;
				b5.setText("b3.setManged("+isManged+")");
			}
		});

		b6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				b3.setVisible(isVisable);
				new Print(hbox);
				isVisable=!isVisable;
				b6.setText("b3.setVisable("+isVisable+")");
			}
		});

		b7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				b3.setOpacity(opacityValue);
				new Print(hbox);
				if(opacityValue==0) {
					opacityValue=1;
					b7.setText("b3.setOpacity("+opacityValue+")");
				}else {
					opacityValue=0;
					b7.setText("b3.setOpacity("+opacityValue+")");
				}
			}
		});

	}
}
class Print{
	Print(HBox hbox){
		System.out.println("hbox的子控件数量="+hbox.getChildren().size());
	}
}
