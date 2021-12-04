package fx.com;

import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class Main1 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setOpacity(0.8);//Í¸Ã÷¶È
		
//		primaryStage.setAlwaysOnTop(true);//
		
		primaryStage.setX(250);
		primaryStage.setY(150);
		
		primaryStage.setHeight(450);
		primaryStage.setWidth(750);
		
		primaryStage.xProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("X="+newValue);
			}
		});
		
		primaryStage.yProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				System.out.println("Y="+arg2);
			}
			
		});
		
		primaryStage.show();
	}

}
