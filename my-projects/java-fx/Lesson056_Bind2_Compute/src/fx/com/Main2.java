package fx.com;

import java.util.function.DoubleBinaryOperator;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane an=new AnchorPane();
		
		TextField tf=new TextField();
		
		Button bu=new Button("button");
		
		an.getChildren().addAll(bu,tf);
		Scene sc=new Scene(an);
		primaryStage.setScene(sc);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		SimpleIntegerProperty x=new SimpleIntegerProperty(2);
		
		DoubleBinding db=an.widthProperty().divide(x);
		
		bu.prefWidthProperty().bind(db);
		bu.prefHeightProperty().bind(an.heightProperty().divide(x));
		
		tf.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				try {
					int value=Integer.parseInt(newValue);
					x.set(value);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("catch  e");
				}
				
			}
		});
		
		
		
	}

}
