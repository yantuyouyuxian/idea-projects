package fx.com;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main3 extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Stage s1=new Stage();
		s1.setTitle("s1");
		
		
		Stage s2=new Stage();
		s2.setTitle("s2");
//		s2.initOwner(s1);//s2属于s1，关闭s1则s2关闭
//		s2.initModality(Modality.WINDOW_MODAL);阻止相关联的其他窗口的操作
		
		Stage s3=new Stage();
//		s3.initModality(Modality.APPLICATION_MODAL);//不关闭无法操作其他窗口
		s3.setTitle("s3");
		
		
		s1.show();
		s2.show();
		s3.show();
		
		
	}

}
