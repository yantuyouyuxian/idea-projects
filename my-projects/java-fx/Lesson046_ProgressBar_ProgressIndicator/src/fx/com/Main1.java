/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	ScheduledService<Double> sche;

	
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
		
		
		AnchorPane an=new AnchorPane();
		
		ProgressBar pb=new ProgressBar();
		
		ProgressIndicator pi=new ProgressIndicator();
		
//		pb.setProgress(0.1);
//		pb.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
//		pb.setPrefWidth(400);
		
		pi.setMinSize(100, 100);
		
		
		an.getChildren().addAll(pb,pi);
		AnchorPane.setTopAnchor(pb, 200.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		pb.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});
		
		sche=new ScheduledService<Double>() {
			double i=0;
			@Override
			protected Task<Double> createTask() {
				// TODO Auto-generated method stub
				Task<Double> task=new Task<Double>() {
					
					@Override
					protected Double call() throws Exception {
						// TODO Auto-generated method stub
						return i=i+0.1;
					}

					@Override
					protected void updateValue(Double value) {
						// TODO Auto-generated method stub
						super.updateValue(value);
						if(i>=1) {
							sche.cancel();
						}
						pb.setProgress(value);
						pi.setProgress(value);
					}
				};
				return task;
			}
		};
		
		sche.setDelay(Duration.millis(0));
		sche.setPeriod(Duration.millis(500));
		sche.start();
		
	}

}

