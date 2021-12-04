package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("FavaFx");
		primaryStage.getIcons().add(new Image("./images/icon.png"));
		
//		primaryStage.setIconified(true);
		
//		primaryStage.setMaximized(true);
		
//		primaryStage.close();
		
//		primaryStage.setResizable(false);
		
		
		
		primaryStage.setHeight(600);
		
		primaryStage.setWidth(1000);
		
		
//		primaryStage.setMaxHeight(900);
		
//		primaryStage.setMaxWidth(1500);
		
		
		
		primaryStage.setMinHeight(300);
		
		primaryStage.setMinWidth(500);
		
		
		primaryStage.setFullScreen(true);
		
		primaryStage.setScene(new Scene(new Group()));//
		
		
		
		primaryStage.show();
		
		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				System.out.println("height "+arg2.doubleValue());
			}
			
		});
		
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("width "+newValue.doubleValue());
			}
		});
		
//		Stage stage=new Stage();
//		stage.show();
	}

}
