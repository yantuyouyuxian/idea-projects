package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main3 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane an=new AnchorPane();
		
		TextField t1=new TextField();
		
		TextField t2=new TextField();
		
		
		
		
		an.getChildren().addAll(t1,t2);
		
		AnchorPane.setLeftAnchor(t2, 300.0);
		Scene sc=new Scene(an);
		primaryStage.setScene(sc);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
//		t1.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				t2.setText(newValue);
//			}
//		});
//		
//		t2.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				t1.setText(newValue);
//			}
//		});
		
		
//		t1.textProperty().bindBidirectional(t2.textProperty());
		//单向绑定后不能修改
		
		t1.textProperty().bindBidirectional(t2.textProperty(), new StringConverter<String>() {

			@Override
			public String toString(String object) {
				// TODO Auto-generated method stub
				return object;
			}

			@Override
			public String fromString(String string) {
				// TODO Auto-generated method stub
				if(string.contains("5")) {
					String str=string.replace("5", "五");
					return str;
				}
				return string;
			}
		});
		
	}
}