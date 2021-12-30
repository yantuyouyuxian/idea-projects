package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main4 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane an=new AnchorPane();
		
		Slider slider=new Slider(0,500,0);
		slider.setPrefWidth(500);
		
		Button bu=new Button("button");
		
		an.getChildren().addAll(bu,slider);
		
		AnchorPane.setTopAnchor(slider, 200.0);
		Scene sc=new Scene(an);
		primaryStage.setScene(sc);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
//		slider.valueProperty().addListener(new ChangeListener<Number>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				// TODO Auto-generated method stub
//				bu.setTranslateX(newValue.doubleValue());
//			}
//		});
		
		bu.translateXProperty().bind(slider.valueProperty());
	}
}