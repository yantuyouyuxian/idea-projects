package fx.com;

import javafx.application.*;
import javafx.stage.Stage;

public class Main1 extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Platform.runLater() "+Thread.currentThread().getName());
				
				int i=1;
				while(i<=10){
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("i= "+i);
					i++;
				}
			}
			
		});
		
		System.out.println("start() "+Thread.currentThread().getName());
	}

}
