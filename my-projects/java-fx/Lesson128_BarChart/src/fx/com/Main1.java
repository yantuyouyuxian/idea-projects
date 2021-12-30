/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

		BarChart<String, Number> barchart1 = getView1();

		BarChart<String, Number> barchart2 = getView2();

		BarChart<String, Number> barchart3 = getView3();
		
		BarChart<String, Number> barchart4 = getView4();
		
		BarChart<String, Number> barchart5 = getView5();

		HBox hbox = new HBox();
		hbox.getChildren().addAll(barchart1, barchart2);
		
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(barchart3,barchart4,barchart5);
		
		VBox vbox=new VBox();
		vbox.getChildren().addAll(hbox,hbox2);
		AnchorPane root = new AnchorPane(vbox);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

	}

	public BarChart getView1() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("国家");

		NumberAxis y = new NumberAxis(0, 100, 10);
		y.setLabel("GDP");

		ObservableList<XYChart.Series<String, Number>> list_data = FXCollections.observableArrayList();

		XYChart.Series<String, Number> xy = new XYChart.Series<String, Number>();
		xy.setName("GDP");
		ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
		XYChart.Data<String, Number> d1 = new XYChart.Data<String, Number>("中国", 80);
		XYChart.Data<String, Number> d2 = new XYChart.Data<String, Number>("美国", 60);
		XYChart.Data<String, Number> d3 = new XYChart.Data<String, Number>("日本", 40);
		data.addAll(d1, d2, d3);
		
		xy.setData(data);// 一个序列需要一个data列表

		list_data.addAll(xy);// 添加一个序列

		BarChart<String, Number> barchart = new BarChart<String, Number>(x, y, list_data);
		barchart.setTitle("NO.1");
		return barchart;
	}

	public BarChart getView2() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("生产类别");

		NumberAxis y = new NumberAxis(0, 100, 10);
		y.setLabel("总值");

		// 一个序列是一种颜色
		XYChart.Series<String, Number> xy1 = new XYChart.Series<String, Number>();
		xy1.setName("中国");

		XYChart.Series<String, Number> xy2 = new XYChart.Series<String, Number>();
		xy2.setName("美国");

		XYChart.Series<String, Number> xy3 = new XYChart.Series<String, Number>();
		xy3.setName("日本");

		XYChart.Data<String, Number> d1 = new XYChart.Data<String, Number>("GDP", 80);
		XYChart.Data<String, Number> d2 = new XYChart.Data<String, Number>("GDP", 60);
		XYChart.Data<String, Number> d3 = new XYChart.Data<String, Number>("GDP", 40);

		XYChart.Data<String, Number> d4 = new XYChart.Data<String, Number>("GNP", 30);
		XYChart.Data<String, Number> d5 = new XYChart.Data<String, Number>("GNP", 40);
		XYChart.Data<String, Number> d6 = new XYChart.Data<String, Number>("GNP", 50);

		xy1.getData().addAll(d1, d4);
		xy2.getData().addAll(d2, d5);
		xy3.getData().addAll(d3, d6);

		BarChart<String, Number> barchart = new BarChart<String, Number>(x, y);

		barchart.getData().addAll(xy1, xy2, xy3);
		barchart.setTitle("NO.2");

		return barchart;
	}

	public BarChart getView3() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("国家");

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

		xy1.getData().addAll(d1, d3, d5);
		xy2.getData().addAll(d2, d4, d6);

		BarChart<String, Number> barchart = new BarChart<String, Number>(x, y);

		barchart.getData().addAll(xy1, xy2);
		barchart.setTitle("NO.3");

		return barchart;
	}
	
	public BarChart getView4() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("国家");
		NumberAxis y = new NumberAxis(0, 100, 10);
		y.setLabel("生产总值");

		XYChart.Series<Number, String> xy=new XYChart.Series<Number, String>();
		xy.setName("生产总值");
		
		XYChart.Data<Number,String> d1 = new XYChart.Data<Number,String>(80,"中国");
		XYChart.Data<Number,String> d2 = new XYChart.Data<Number,String>(60,"美国");
		XYChart.Data<Number,String> d3 = new XYChart.Data<Number,String>(40,"日本");

		xy.getData().addAll(d1,d2,d3);
		
		BarChart<Number,String> barchart = new BarChart<Number, String>(y, x);

		barchart.getData().addAll(xy);
		barchart.setTitle("NO.4");

		return barchart;
	}
	public BarChart getView5() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("国家");
		NumberAxis y = new NumberAxis(0, 100, 10);
		y.setLabel("生产总值");

		XYChart.Series<Number, String> xy1=new XYChart.Series<Number, String>();
		xy1.setName("中国");
		XYChart.Series<Number, String> xy2=new XYChart.Series<Number, String>();
		xy2.setName("美国");
		XYChart.Series<Number, String> xy3=new XYChart.Series<Number, String>();
		xy3.setName("日本");
		
		XYChart.Data<Number,String> d1 = new XYChart.Data<Number,String>(80,"中国");
		XYChart.Data<Number,String> d2 = new XYChart.Data<Number,String>(60,"美国");
		XYChart.Data<Number,String> d3 = new XYChart.Data<Number,String>(40,"日本");

		xy1.getData().addAll(d1);
		xy2.getData().addAll(d2);
		xy3.getData().addAll(d3);
		
		BarChart<Number,String> barchart = new BarChart<Number, String>(y, x);

		barchart.getData().addAll(xy1,xy2,xy3);
		barchart.setTitle("NO.5");

		return barchart;
	}

}
