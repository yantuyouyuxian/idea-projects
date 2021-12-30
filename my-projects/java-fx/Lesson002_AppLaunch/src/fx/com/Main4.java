package fx.com;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application{
	
	public static void main(String[] args) {
		System.out.println("main1 "+Thread.currentThread().getName());
		launch(args);
		System.out.println("main2 "+Thread.currentThread().getName());
	}
	
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init "+Thread.currentThread().getName());
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("start "+Thread.currentThread().getName());
		primaryStage.show();
	}
	
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("stop "+Thread.currentThread().getName());
	}
	
	

}
