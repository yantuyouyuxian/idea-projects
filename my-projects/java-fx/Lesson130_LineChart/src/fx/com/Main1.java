/**
 * 
 */
package fx.com;

import java.net.URL;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
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
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		LineChart<Number,Number> linechart1=getView1();
		linechart1.setId("linechart");
		
		LineChart<String,Number> linechart2=getView2();
		
		LineChart<Number,String> linechart3=getView3();
		
		Button bu=new Button("button");
		HBox hbox=new HBox(20);
		hbox.getChildren().addAll(linechart1,linechart2,linechart3);
		
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

	public LineChart<Number, Number> getView1(){
		
		NumberAxis x=new NumberAxis("x",0,100,10);
		
		NumberAxis y=new NumberAxis("y",0,100,10);
		
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
		
		LineChart<Number, Number> linechart=new LineChart<>(x, y);
		
		linechart.getData().addAll(xy1,xy2);
		
		xy1.getData().forEach(new Consumer<XYChart.Data<Number, Number>>() {

			@Override
			public void accept(Data<Number, Number> t) {
				// TODO Auto-generated method stub
				
				Tooltip tip=new Tooltip(t.getXValue()+" "+t.getYValue());
				Tooltip.install(t.getNode(), tip);
				
				t.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		});
		
		
		
		
//		linechart.setCreateSymbols(false);//是否显示连接点
		return linechart;
	}

	
	public LineChart<String, Number> getView2(){
		
		CategoryAxis x=new CategoryAxis();
		NumberAxis y=new NumberAxis("y",0,100,10);
		
		XYChart.Series<String, Number> xy1=new XYChart.Series<>();
		xy1.setName("2019");
		
		XYChart.Series<String, Number> xy2=new XYChart.Series<>();
		xy2.setName("2020");
		
		XYChart.Data<String, Number> d1=new XYChart.Data<>("春",10);
		XYChart.Data<String, Number> d2=new XYChart.Data<>("夏",20);
		XYChart.Data<String, Number> d3=new XYChart.Data<>("秋",30);
		XYChart.Data<String, Number> d4=new XYChart.Data<>("冬",40);
		
		XYChart.Data<String, Number> d5=new XYChart.Data<>("春",20);
		XYChart.Data<String, Number> d6=new XYChart.Data<>("夏",40);
		XYChart.Data<String, Number> d7=new XYChart.Data<>("秋",60);
		XYChart.Data<String, Number> d8=new XYChart.Data<>("冬",80);
		
		xy1.getData().addAll(d1,d2,d3,d4);
		xy2.getData().addAll(d5,d6,d7,d8);
		
		LineChart<String, Number> linechart=new LineChart<>(x, y);
		linechart.getData().addAll(xy1,xy2);
//		linechart.setCreateSymbols(false);//是否显示连接点
		return linechart;
	}
	
	public LineChart<Number, String> getView3(){
		
		NumberAxis x=new NumberAxis("人數",0,100,10);
		
		CategoryAxis y=new CategoryAxis();
		y.setLabel("等級");
		
		
		XYChart.Series<Number, String> xy1=new XYChart.Series<>();
		xy1.setName("一年級");
		
		XYChart.Series<Number, String> xy2=new XYChart.Series<>();
		xy2.setName("二年級");
		
		XYChart.Data<Number, String> d1=new XYChart.Data<>(10,"A");
		XYChart.Data<Number, String> d2=new XYChart.Data<>(20,"B");
		XYChart.Data<Number, String> d3=new XYChart.Data<>(30,"C");
		XYChart.Data<Number, String> d4=new XYChart.Data<>(40,"D");
		
		XYChart.Data<Number, String> d5=new XYChart.Data<>(40,"A");
		XYChart.Data<Number, String> d6=new XYChart.Data<>(30,"B");
		XYChart.Data<Number, String> d7=new XYChart.Data<>(20,"C");
		XYChart.Data<Number, String> d8=new XYChart.Data<>(10,"D");
		
		xy1.getData().addAll(d1,d2,d3,d4);
		xy2.getData().addAll(d5,d6,d7,d8);
		
		LineChart<Number, String> linechart=new LineChart<>(x, y);
		linechart.getData().addAll(xy1,xy2);
//		linechart.setCreateSymbols(false);//是否显示连接点
		return linechart;
	}
}
