/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	int i;
	
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
		an.setStyle("-fx-background-color:yellow");
		Slider slider=new Slider(0,50,0);
		
		slider.setPrefWidth(300);
		slider.setPrefHeight(300);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setOrientation(Orientation.VERTICAL);
		
		AnchorPane.setTopAnchor(slider, 200.0);
		
		
		an.getChildren().addAll(slider);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		slider.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		My my=new My(slider);
		my.setDelay(Duration.millis(0));
		my.setPeriod(Duration.millis(250));
		
		my.start();
		
		my.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				// TODO Auto-generated method stub
				System.out.println("my Thread= "+Thread.currentThread().getName());
				System.out.println("my newValue= "+newValue+" oldValue="+oldValue);
				if(newValue!=null) {
					slider.setValue(newValue.intValue());
				}
			}
		});
//		slider.setLabelFormatter(new StringConverter<Double>() {
//			
//			@Override
//			public String toString(Double object) {
//				// TODO Auto-generated method stub
//				System.out.println(object);
//				if(object.doubleValue()==0) {
//					return "零";
//				}
//				return "未知";
//			}
//			
//			@Override
//			public Double fromString(String string) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		
		
		
//		slider.valueProperty().addListener(new ChangeListener<Number>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue.doubleValue());
//				slider.setValueChanging(true);
//		}
//		});
//		
//		slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//		});
	
		
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for(i=0;i<=50;i++) {
//					Platform.runLater(new Runnable() {
//						
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							slider.setValue(i);
//							System.out.println("Platform "+Thread.currentThread().getName());
//						}
//					});
//					System.out.println("new Thread "+Thread.currentThread().getName());
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
		
		
	}

}

class My extends ScheduledService<Integer>{
	
	int i=0;
	Slider s;
	public My(Slider s) {
		this.s=s;
	}
	
	@Override
	protected Task<Integer> createTask() {
		// TODO Auto-generated method stub
		Task task=new Task<Integer>() {

			@Override
			protected Integer call() throws Exception {
				// TODO Auto-generated method stub
				return i=i+1;
			}
			
			//上面的方法返回的i进入下面的方法
			
//			@Override
//			protected void updateValue(Integer value) {
//				// TODO Auto-generated method stub
//				super.updateValue(value);
				
//				if(i==50) {
//					My.this.cancel();
//				}
//				s.setValue(i);
//			}
			
			
		};
		
		return task;
	}
	
}

