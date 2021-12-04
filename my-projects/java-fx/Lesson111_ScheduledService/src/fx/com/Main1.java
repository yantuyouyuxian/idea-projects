/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
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
import javafx.util.Duration;

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
		
		MyScheduledService mss=new MyScheduledService();
		mss.setDelay(Duration.seconds(5));//
		mss.setPeriod(Duration.seconds(1));
		mss.setRestartOnFailure(true);
		mss.setMaximumFailureCount(3);
		
		
		start.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mss.start();
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mss.cancel();
			}
		});
		restart.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mss.restart();
			}
		});
		reset.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mss.reset();
			}
		});
		

		mss.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				if(newValue != null) {
					l2.setText(newValue.toString());
				}
			}
		});
		
		mss.lastValueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				if(newValue != null) {
					System.out.println("lastValue= "+newValue.intValue());
				}
				
			}
		});//最新的value，在updateValue()之后
		
		mss.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mss.messageProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
class MyScheduledService extends ScheduledService<Number>{

	int sum=0;
	@Override
	protected Task<Number> createTask() {
		// TODO Auto-generated method stub
		System.out.println("createTask   "+Thread.currentThread().getName());
		Task<Number> task=new Task<Number>() {

			@Override
			protected void updateValue(Number value) {
				// TODO Auto-generated method stub
				super.updateValue(value);
				if(value.intValue()== 10) {
					MyScheduledService.this.cancel();
					System.out.println("cancel   "+Thread.currentThread().getName());
				}
			}

			@Override
			protected Number call() throws Exception {
				// TODO Auto-generated method stub
				sum+=1;
				System.out.println("sum = "+sum+"   "+Thread.currentThread().getName());
				return sum;
			}
		};
		return task;
	}
	
}

