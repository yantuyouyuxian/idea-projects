/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * @author Z H
 *GridPane
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
		
		Button b1=new Button("button1");
		Button b2=new Button("button2");
		Button b3=new Button("button3");
		Button b4=new Button("button4");
		Button b5=new Button("button5");
		Button b6=new Button("button6");
		Button b7=new Button("button7");
		Button b8=new Button("button8");
		Button b9=new Button("button9");
		Button b10=new Button("button10");
		
		GridPane gp=new GridPane();
		gp.setStyle("-fx-background-color:gray");
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 2, 0);
		gp.add(b4, 3, 0);
		gp.add(b5, 0, 1);
		gp.add(b6, 1, 1);
		gp.add(b7, 2, 1);
		gp.add(b8, 3, 1);
		
		
//		gp.setVgap(5);
//		gp.setHgap(5);
		
		gp.setPadding(new Insets(10));
		
//		gp.setMargin(b1, new Insets(10));
		
//		gp.setAlignment(Pos.CENTER);
		
		//添加组件的第二种方法
		gp.setConstraints(b9, 0, 2);//设置约束
		gp.getChildren().add(b9);//添加组件
		
		
		//第三种
		gp.setRowIndex(b10, 2);
		gp.setColumnIndex(b10, 1);
		gp.getChildren().add(b10);
		
		
//		gp.getColumnConstraints().add(new ColumnConstraints(100));
//		gp.getColumnConstraints().add(new ColumnConstraints(100));
//		gp.getRowConstraints().add(new RowConstraints(50));
//		gp.getRowConstraints().add(new RowConstraints(50));
		
		Scene scene=new Scene(gp);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
