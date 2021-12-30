/**
 * 
 */
package fx.com;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;

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
	
		WebView web=new WebView();
		WebEngine engine=web.getEngine();
		engine.load("https://www.baidu.com/");
		
		WebHistory history=engine.getHistory();
		ObservableList<WebHistory.Entry> obslist=history.getEntries();
		
		
		
		HBox hbox=new HBox(20);
		Button b1=new Button("前进");
		Button b2=new Button("后退");
		Button b3=new Button("信息");
		hbox.getChildren().addAll(b1,b2,b3);

		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox,web);
		AnchorPane.setTopAnchor(web, 30.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	
		web.prefWidthProperty().bind(root.widthProperty());
		web.prefHeightProperty().bind(root.heightProperty().subtract(30));
	
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				engine.load(null);
				Platform.exit();
			}
		});
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(history.getCurrentIndex() != obslist.size()-1) {
					history.go(1);
				}
				
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(history.getCurrentIndex()!=0) {
					history.go(-1);
				}
			}
		});
		
		b3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("now: "+history.getCurrentIndex());
				System.out.println("max: "+history.getMaxSize());
				System.out.println("sum: "+obslist.size());
				obslist.forEach(item->{
					System.out.println(item);
				});
			}
		});
		
	}
}
