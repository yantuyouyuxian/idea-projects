/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * @author Z H
 *Tab TabpPane
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
		
		AnchorPane an=new AnchorPane();
		
		TabPane tabpane=new TabPane();
		
		
		
		Tab tab1=new Tab("tab1");
		Tab tab2=new Tab("tab2");
		Tab tab3=new Tab("tab3");
		
		HBox hbox=new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.setStyle("-fx-background-color:gray");
		hbox.getChildren().addAll(new Button("button1"),new Button("button1"));
		tab1.setContent(hbox);
		
		VBox vbox=new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color:blue");
		vbox.getChildren().addAll(new Button("button3"),new Button("button4"));
		tab2.setContent(vbox);
		
		

		tabpane.setPrefHeight(200);
		tabpane.setPrefWidth(200);
		tabpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("blue"), new CornerRadii(10), new Insets(50))));
		tabpane.setBorder(new Border(new BorderStroke(Paint.valueOf("yellow"), BorderStrokeStyle.DOTTED,new CornerRadii(20),new BorderWidths(5))));
//		tabpane.setStyle("-fx-background-color:red");
		tabpane.getTabs().addAll(tab1,tab2,tab3);
		
		
		
		an.getChildren().add(tabpane);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		
		ImageView image=new ImageView("images/icon.png");
		image.setFitWidth(25);
		image.setFitHeight(25);
		tab1.setGraphic(image);
//		tabpane.setSide(Side.LEFT);//加载图片和设置方向要在show（）前面才能不改变图片方向
		
		primaryStage.show();
		
		
		
//		tab2.setClosable(false);
		
//		tab2.setDisable(true);
		
//		tabpane.setRotateGraphic(false);
		
//		tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
//		tabpane.getSelectionModel().select(tab2);
		
//		tabpane.getSelectionModel().selectLast();
		
//		tabpane.getSelectionModel().selectPrevious();
		
		tabpane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.getText());
			}
		});
		
		tab1.setOnSelectionChanged(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("tab1.setOnSelectionChanged() "+((Tab)event.getSource()).isSelected());
			}
		});
		
		an.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tabpane.getTabs().add(new Tab("tab"));
			}
		});
		
		tab1.setOnClosed(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("tab1.setOnClosed()");
			}
		});
		
		tab1.setOnCloseRequest(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("tab1.setOnCloseRequest()");
				
//				event.consume();
			}
		});
		
	}

}
