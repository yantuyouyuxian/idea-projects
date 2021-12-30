/**
 * 
 */
package fx.com;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
		GridPane grid=new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				Rectangle rec=new Rectangle(200,200);
				rec.setFill(Paint.valueOf("gray"));
				
				grid.add(rec, j, i);
			}
		}
		
		ArrayList<Paint> list=new ArrayList<>();
		
		Stop[] stops=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg1=new RadialGradient(0, 0, 0, 0, 100, false, CycleMethod.NO_CYCLE, stops);
		list.add(rg1);
		
		Stop[] stops2=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg2=new RadialGradient(0, 0, 100, 100, 100, false, CycleMethod.NO_CYCLE, stops2);
		list.add(rg2);
		
		Stop[] stops3=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg3=new RadialGradient(0, 1, 100, 100, 100, false, CycleMethod.NO_CYCLE, stops3);
		list.add(rg3);
		
		Stop[] stops4=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg4=new RadialGradient(0, -1, 100, 100, 100, false, CycleMethod.NO_CYCLE, stops4);
		list.add(rg4);
		
		Stop[] stops5=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg5=new RadialGradient(45, -1, 100, 100, 100, false, CycleMethod.NO_CYCLE, stops5);
		list.add(rg5);//顺时针角度为正
		
		Stop[] stops6=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg6=new RadialGradient(0, -1, 100, 100, 100, false, CycleMethod.NO_CYCLE, stops6);
		list.add(rg6);
		
		Stop[] stops7=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da"))};
		RadialGradient rg7=new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops7);
		list.add(rg7);
		
		Stop[] stops8=new Stop[] {new Stop(0,Color.valueOf("#de1e1e")),new Stop(0.5,Color.valueOf("#23bfd6")),new Stop(1, Color.valueOf("#3567da00"))};
		RadialGradient rg8=new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops8);
		list.add(rg8);
		
		
		
		for(int i=0;i<list.size();i++) {
			Rectangle rec=(Rectangle)grid.getChildren().get(i);
			rec.setFill(list.get(i));
		}
		HBox hbox=new HBox(20);
		hbox.getChildren().add(new Circle(100));
		hbox.getChildren().add(new Circle(100));
		hbox.getChildren().add(new Circle(100));
		hbox.getChildren().add(new Circle(100));
		hbox.getChildren().add(new Polygon(100,0,200,200,0,200));
		
		
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(grid,hbox);
		AnchorPane.setTopAnchor(hbox, 500.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
	
	}
}
