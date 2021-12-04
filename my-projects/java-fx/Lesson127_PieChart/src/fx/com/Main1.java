/**
 * 
 */
package fx.com;

import java.net.URL;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
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
		
		PieChart.Data d1=new PieChart.Data("data1", 20);
		PieChart.Data d2=new PieChart.Data("data2", 20);
		PieChart.Data d3=new PieChart.Data("data3", 30);
		PieChart.Data d4=new PieChart.Data("data4", 40);
		PieChart.Data d5=new PieChart.Data("data5", 40);
		ObservableList<PieChart.Data> datalist=FXCollections.observableArrayList();
		datalist.addAll(d1,d2,d3,d4);
		PieChart piechart=new PieChart(datalist);
//		piechart.setLabelLineLength(value);
//		piechart.setClockwise(true);//默认是true
//		piechart.setStartAngle(90);//逆时针旋转
//		piechart.setLabelsVisible(true);
//		piechart.setLegendVisible(true);//插图说明
//		piechart.setLegendSide(Side.LEFT);
//		piechart.setTitle("title");
//		piechart.setTitleSide(value);
//		piechart.setAnimated(true);//改变动画
		
		
		piechart.getData().forEach(new Consumer<PieChart.Data>() {

			@Override
			public void accept(Data t) {
				// TODO Auto-generated method stub
				
				System.out.println(t.getName()+" "+t.getPieValue());
				t.pieValueProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
							Number newValue) {
					
					}
				});
			}
		});
		
		Button bu=new Button("button");
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu,piechart);

		AnchorPane.setTopAnchor(piechart, 50.0);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();

//		URL url=this.getClass().getClassLoader().getResource("");
//		scene.getStylesheets().add(url.toExternalForm());

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				datalist.add(d5);
			}
		});
	}

}




