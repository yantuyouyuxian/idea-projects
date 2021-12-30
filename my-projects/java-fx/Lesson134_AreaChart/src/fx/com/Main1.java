/**
 * 
 */
package fx.com;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application {

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

		AreaChart<Number, Number> chart=getView();
	
		Button bu = new Button("button");
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(chart);

		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox);

		URL url=this.getClass().getClassLoader().getResource("css/mycss.css");
		root.getStylesheets().add(url.toExternalForm());

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});
	}

public AreaChart<Number, Number> getView(){
		
		NumberAxis x=new NumberAxis("x",0,100,10);
		NumberAxis y=new NumberAxis("y",0,100,10);
		
		AreaChart<Number, Number> chart=new AreaChart<>(x, y);
		
		XYChart.Series<Number, Number> xy1=new XYChart.Series<Number, Number>();
		xy1.setName("y=x");
		
		XYChart.Series<Number, Number> xy2=new XYChart.Series<Number, Number>();
		xy2.setName("y=2x");
		
		XYChart.Data<Number, Number> d1=new XYChart.Data<>(10,10);
		XYChart.Data<Number, Number> d2=new XYChart.Data<>(20,20);
		XYChart.Data<Number, Number> d3=new XYChart.Data<>(30,30);
		XYChart.Data<Number, Number> d4=new XYChart.Data<>(40,40);
		
		XYChart.Data<Number, Number> d5=new XYChart.Data<>(10,20);
		XYChart.Data<Number, Number> d6=new XYChart.Data<>(20,40);
		XYChart.Data<Number, Number> d7=new XYChart.Data<>(30,60);
		XYChart.Data<Number, Number> d8=new XYChart.Data<>(40,80);
		
		xy1.getData().addAll(d1,d2,d3,d4);
		xy2.getData().addAll(d5,d6,d7,d8);
		
		chart.getData().addAll(xy1,xy2);
		
//		chart.setCreateSymbols(true);
		
		return chart;
	}

}
