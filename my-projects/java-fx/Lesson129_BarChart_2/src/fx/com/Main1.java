/**
 * 
 */
package fx.com;

import java.net.URL;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		CategoryAxis x = new CategoryAxis();
		x.setLabel("国家");
//		x.setId("x");
//		x.setStartMargin(value);
//		x.setEndMargin(value);
//		x.setGapStartAndEnd(true);
		
//		x.setSide(Side.TOP);
//		x.setTickLabelFill(Paint.valueOf(value));
//		x.setTickLabelFill(new Font(size));
//		x.setTickLabelGap(100);
//		x.setTickLabelRotation(45);
//		x.setTickLabelsVisible(true);
//		x.setTickLength();
//		x.setTickMarkVisible(true);

		NumberAxis y = new NumberAxis(0, 100, 10);
		y.setLabel("生产总值");

		// 一个序列是一种颜色
		XYChart.Series<String, Number> xy1 = new XYChart.Series<String, Number>();
		xy1.setName("GDP");
		

		XYChart.Series<String, Number> xy2 = new XYChart.Series<String, Number>();
		xy2.setName("GNP");

		XYChart.Data<String, Number> d1 = new XYChart.Data<String, Number>("中国", 80);
		XYChart.Data<String, Number> d2 = new XYChart.Data<String, Number>("中国", 30);

		XYChart.Data<String, Number> d3 = new XYChart.Data<String, Number>("美国", 60);
		XYChart.Data<String, Number> d4 = new XYChart.Data<String, Number>("美国", 40);

		XYChart.Data<String, Number> d5 = new XYChart.Data<String, Number>("日本", 40);
		XYChart.Data<String, Number> d6 = new XYChart.Data<String, Number>("日本", 50);

//		d1.setExtraValue(value);

		xy1.getData().addAll(d1, d3, d5);
//		xy1.getData().forEach(new Consumer<XYChart.Data<String, Number>>() {
//
//			@Override
//			public void accept(Data<String, Number> t) {
//				// TODO Auto-generated method stub
//				System.out.println(t.getXValue()+" "+t.getYValue());
//				
//				HBox h1=new HBox();
//				h1.setAlignment(Pos.CENTER);
//				h1.setStyle("-fx-background-color:#ffff55");
//				h1.getChildren().add(new Label(String.valueOf(t.getYValue())));
//				
//				t.setNode(h1);
//				
//				t.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//					@Override
//					public void handle(MouseEvent event) {
//						// TODO Auto-generated method stub
//						System.out.println(t.getXValue()+" "+t.getYValue());
//					}
//				});
//			}
//		});
		
		xy2.getData().addAll(d2, d4, d6);

		BarChart<String, Number> barchart = new BarChart<String, Number>(x, y);

		barchart.getData().add(xy1);
		barchart.getData().add(xy2);
		
		
		
//		barchart.setBarGap(10);//Series的间隙
//		barchart.setCategoryGap(10);//间距
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().add(barchart);
		
		
		URL url=this.getClass().getClassLoader().getResource("css/NewFile.css");
		root.getStylesheets().add(url.toExternalForm());
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

	}

	

}
