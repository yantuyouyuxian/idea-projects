/**
 * 
 */
package fx.com;


import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
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
		
		NumberAxis x=new NumberAxis("x",0,20,1);
		
		NumberAxis y=new NumberAxis("y",0,100,10);
		
		LineChart<Number, Number> chart=new LineChart<Number, Number>(x,y);
		chart.setPrefWidth(800);
		chart.setPrefHeight(500);
//		chart.setAnimated(false);
		
		XYChart.Series<Number, Number> xy1=new XYChart.Series<>();
		xy1.setName("xy1");
		
		XYChart.Series<Number, Number> xy2=new XYChart.Series<>();
		xy2.setName("xy2");
		
		chart.getData().addAll(xy1,xy2);
		
		
		Button play=new Button("¼à¿Ø");
		Button stop=new Button("Í£Ö¹");
		
		HBox hbox=new HBox(20);
		hbox.getChildren().addAll(play,stop);
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox,chart);
		
		AnchorPane.setLeftAnchor(hbox, 50.0);
		AnchorPane.setTopAnchor(hbox, 50.0);
		
		AnchorPane.setLeftAnchor(chart, 50.0);
		AnchorPane.setTopAnchor(chart, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		DataTask task=new DataTask();
		task.setDelay(Duration.seconds(0));
		task.setPeriod(Duration.seconds(0.5));
		
		task.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>() {

			@Override
			public void changed(ObservableValue<? extends ArrayList<Integer>> observable, ArrayList<Integer> oldValue,
					ArrayList<Integer> newValue) {
				// TODO Auto-generated method stub
				if(newValue != null) {
					int value1=newValue.get(0);
					
					int value2=newValue.get(1);
					System.out.println(value1+"  "+value2);
					
					int xindex=xy1.getData().size();
					
					if(xindex == 50) {
						xy1.getData().clear();
						xy2.getData().clear();
						x.setLowerBound(0);
						x.setUpperBound(20);
						xindex=0;
					}
						
					if(xindex > 18) {
						x.setLowerBound(x.getLowerBound()+1);
						x.setUpperBound(x.getUpperBound()+1);
					}
					
					XYChart.Data<Number, Number> data1=new XYChart.Data<>(xindex,value1);
					
					XYChart.Data<Number, Number> data2=new XYChart.Data<>(xindex,value2);
					
					xy1.getData().add(data1);
					xy2.getData().add(data2);
					
					
					
				}
			}
		});
		
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(task.isRunning() == false) {
					task.start();
				}
			}
		});
		
		stop.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
//				if(task.isRunning()) {
					task.cancel();
					task.reset();
//				}
			}
		});
		
	}

}

class DataTask extends ScheduledService<ArrayList<Integer>>{

	@Override
	protected Task<ArrayList<Integer>> createTask() {
		// TODO Auto-generated method stub
		
		Task<ArrayList<Integer>> task=new Task<ArrayList<Integer>>() {
			
			@Override
			protected ArrayList<Integer> call() throws Exception {
				// TODO Auto-generated method stub
				
				Random ra=new Random();
				
				int value1=ra.nextInt(100);
				
				int value2=ra.nextInt(100);
				
				ArrayList<Integer> list=new ArrayList<>();
				list.add(value1);
				list.add(value2);
				
				return list;
			}
		};
		
		return task;
	}
}


