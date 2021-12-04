/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		
		Group root=new Group();
		
		Pagination pa=new Pagination();
		
		
		
		pa.setPrefWidth(500);
		
		pa.setPrefHeight(300);
		
		pa.setStyle("-fx-background-color:yellow");
		
		pa.setLayoutX(100);
		
		pa.setLayoutY(100);
		
		pa.setPageCount(10);
		
//		pa.setPageCount(Pagination.INDETERMINATE);
		
		pa.setMaxPageIndicatorCount(3);
		
		pa.setCurrentPageIndex(1);
		
//		pa.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
		
		root.getChildren().addAll(pa);
		
		
	
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		pa.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
//				System.out.println(newValue.intValue());
			}
		});
		
		pa.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer param) {
				// TODO Auto-generated method stub
				if(param==0) {
					
				}
				return new Button("button");
			}
		});
		
	}

}
