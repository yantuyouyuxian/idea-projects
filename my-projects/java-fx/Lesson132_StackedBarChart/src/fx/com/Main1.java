/**
 * 
 */
package fx.com;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
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

		StackedBarChart<String, Number> stackedbarchart = getView();

		Button bu = new Button("button");
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(stackedbarchart);

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

	public StackedBarChart<String, Number> getView() {

		CategoryAxis x = new CategoryAxis();
		x.setLabel("x");
		NumberAxis y = new NumberAxis("y", 0, 200, 10);

		StackedBarChart<String, Number> stackedbarchart = new StackedBarChart<>(x, y);

		XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
		xy1.setName("2019");

		XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
		xy2.setName("2020");

		XYChart.Data<String, Number> d1 = new XYChart.Data<>("春", 10);
		XYChart.Data<String, Number> d2 = new XYChart.Data<>("夏", 20);
		XYChart.Data<String, Number> d3 = new XYChart.Data<>("秋", 30);
		XYChart.Data<String, Number> d4 = new XYChart.Data<>("冬", 40);

		XYChart.Data<String, Number> d5 = new XYChart.Data<>("春", 20);
		XYChart.Data<String, Number> d6 = new XYChart.Data<>("夏", 40);
		XYChart.Data<String, Number> d7 = new XYChart.Data<>("秋", 60);
		XYChart.Data<String, Number> d8 = new XYChart.Data<>("冬", 80);

		xy1.getData().addAll(d1, d2, d3, d4);
		xy2.getData().addAll(d5, d6, d7, d8);

		stackedbarchart.getData().addAll(xy1, xy2);
		// 相同名称的值会累加
//		stackedbarchart.setCategoryGap(0);

		return stackedbarchart;
	}

}
