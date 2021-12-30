/**
 * 
 */
package fx.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

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
		
		HBox hbox=new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		
		ProgressBar pb=new ProgressBar(0);
		pb.setPrefWidth(200);
		
		Button start=new Button("开始");
		Button cancel=new Button("取消");
		
		Label l1=new Label("state");
		Label l2=new Label("value");
		Label l3=new Label("tittle");
		Label l4=new Label("message");
		
		hbox.getChildren().addAll(start,cancel,pb,l1,l2,l3,l4);
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(hbox);
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		MyTask mytask=new MyTask();//只能运行一次
		Thread thread=new Thread(mytask);
//		thread.setDaemon(true);//守护进程
		start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				thread.start();
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mytask.cancel();
//				thread.stop();
			}
		});
		
		mytask.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				pb.setProgress(newValue.doubleValue());
			}
		});
//		pb.progressProperty().bind(mytask.progressProperty());
		
		mytask.titleProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				l3.setText(newValue);
			}
		});
//		l3.textProperty().bind(mytask.titleProperty());
		
		mytask.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				if(newValue.doubleValue() == 1) {
					l2.setText("完成");
				}
			}
		});
//		l2.textProperty().bind(mytask.valueProperty());
		
		mytask.messageProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				l4.setText(newValue);
			}
		});
//		l4.textProperty().bind(mytask.messageProperty());
		
		mytask.stateProperty().addListener(new ChangeListener<State>() {

			@Override
			public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.toString());
				l1.setText(newValue.toString());
			}
		});
//		l1.textProperty().bind(mytask.stateProperty());
		
		mytask.exceptionProperty().addListener(new ChangeListener<Throwable>() {

			@Override
			public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue,
					Throwable newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getMessage());
			}
		});
		
		
	}

}

class MyTask extends Task<Number>{

	@Override
	protected void updateProgress(long workDone, long max) {
		// TODO Auto-generated method stub
		super.updateProgress(workDone, max);
	}

	@Override
	protected void updateProgress(double workDone, double max) {
		// TODO Auto-generated method stub
		super.updateProgress(workDone, max);
	}

	@Override
	protected void updateMessage(String message) {
		// TODO Auto-generated method stub
		super.updateMessage(message);
	}

	@Override
	protected void updateTitle(String title) {
		// TODO Auto-generated method stub
		super.updateTitle(title);
	}

	@Override
	//这里可以更新界面
	protected void updateValue(Number value) {
		// TODO Auto-generated method stub
		super.updateValue(value);
//		System.out.println(value.intValue());
		
//		System.out.println(Platform.isFxApplicationThread());
//		System.out.println(Thread.currentThread().getName());
	}

	@Override
	protected Number call() throws Exception {
		// TODO Auto-generated method stub
		this.updateTitle("copy");
		FileInputStream fis=new FileInputStream(new File("E:\\BaiduNetdiskDownload\\abcd.zip"));
		double max=fis.available();
		
		FileOutputStream fos=new FileOutputStream(new File("E:\\BaiduNetdiskDownload\\abcd2.zip"));
		
		byte[] readbyte=new byte[1024];
		int i=0;
		double sum=0;
		double progress=0;
		while((i=fis.read(readbyte, 0, readbyte.length)) !=-1){
			
			if(this.isCancelled()) {
				break;
			}
			fos.write(readbyte, 0, i);
			sum+=i;
			this.updateProgress(sum, max);
			progress=sum/max;
//			System.out.println(progress);
			if(progress<0.5) {
				this.updateMessage("请耐心等待");
			}
			else if(progress<0.8) {
				this.updateMessage("马上就好");
			}else if(progress<1) {
				this.updateMessage("即将完成");
			}else {
				this.updateMessage("搞定");
			}
//			Thread.sleep(1);
		}
		fos.close();
		fis.close();
		
//		System.out.println(Platform.isFxApplicationThread());
//		System.out.println(Thread.currentThread().getName());
		return progress;//传给updateValue
	}
	
}
