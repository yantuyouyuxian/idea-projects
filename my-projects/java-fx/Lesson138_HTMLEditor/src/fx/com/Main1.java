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
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
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
	
		HTMLEditor html=new HTMLEditor();
		html.setPrefSize(500, 300);
		
		
		Button b1 = new Button("button1");
		Button b2 = new Button("button2");
		
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(b1,b2);

		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox,html);

		AnchorPane.setTopAnchor(html,100.0);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				html.setHtmlText("<font size=\"20\" color=\"blue\">hello world</font>");
//				html.setHtmlText("<img src=\"E:\\Users\\Z H\\Desktop\\images\\tou.jpg\" width=\"200\" height=\"200\"/>");
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println(html.getHtmlText());
			}
		});
		
	}
}
