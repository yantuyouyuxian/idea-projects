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
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventDispatchChain;
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
		Button restart=new Button("重启");
		Button reset=new Button("重置");
		
		Label l1=new Label("state");
		Label l2=new Label("value");
		Label l3=new Label("tittle");
		Label l4=new Label("message");
		
		hbox.getChildren().addAll(start,cancel,restart,reset,pb,l1,l2,l3,l4);
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
		
		MyService ms=new MyService();
		
		
		start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ms.start();
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ms.cancel();
			}
		});
		restart.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ms.restart();
			}
		});
		reset.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ms.reset();
				pb.setProgress(0);
			}
		});
		
//		pb.progressProperty().bind(ms.progressProperty());
//		pb.progressProperty().bind(ms.valueProperty());
		ms.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				pb.setProgress(newValue.doubleValue());
			}
		});
		

		ms.messageProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				l4.setText("message:"+newValue);
			}
		});
		
	}

}
class MyService extends Service<Number>{


	@Override
	protected void ready() {
		// TODO Auto-generated method stub
		super.ready();
		System.out.println("ready   "+Thread.currentThread().getName());
	}



	@Override
	protected void scheduled() {
		// TODO Auto-generated method stub
		super.scheduled();
		System.out.println("scheduled   "+Thread.currentThread().getName());
		
	}



	@Override
	protected void running() {
		// TODO Auto-generated method stub
		super.running();
		System.out.println("running   "+Thread.currentThread().getName());
		
	}



	@Override
	protected void succeeded() {
		// TODO Auto-generated method stub
		super.succeeded();
		System.out.println("succeeded   "+Thread.currentThread().getName());
		
	}



	@Override
	protected void cancelled() {
		// TODO Auto-generated method stub
		super.cancelled();
		System.out.println("canceled "+Thread.currentThread().getName());
		
	}



	@Override
	protected void failed() {
		// TODO Auto-generated method stub
		super.failed();
		System.out.println("failed "+Thread.currentThread().getName());
		
	}


	@Override
	protected void executeTask(Task<Number> task) {
		// TODO Auto-generated method stub
		super.executeTask(task);
		task.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("executedTask:"+newValue);
			}
		});
	}

	
	
	@Override
	protected Task<Number> createTask() {
		// TODO Auto-generated method stub
		
		Task<Number> task=new Task<Number>() {

			@Override
			protected void updateValue(Number value) {
				// TODO Auto-generated method stub
				super.updateValue(value);
			}

			@Override
			protected Number call() throws Exception {
				// TODO Auto-generated method stub
				this.updateTitle("copy");
				FileInputStream fis=new FileInputStream(new File("D:\\迅雷下载\\abcd.zip"));
				double max=fis.available();
				
				FileOutputStream fos=new FileOutputStream(new File("D:\\迅雷下载\\abcd2.zip"));
				
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

				}
				fos.close();
				fis.close();
				
				return progress;//传给updateValue
			}
		};
		
		return task;
	}
	
}

