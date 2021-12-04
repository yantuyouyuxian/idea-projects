/**
 * 
 */
package fx.com;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
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
		Image image=new Image("img/icon.png");
		
		GridPane grid=new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		for(int i=0;i<5;i++) {
			Rectangle rec=new Rectangle(200,200);
			rec.setFill(Paint.valueOf("gray"));
			grid.add(rec, i, 0);
		}
		
		HBox hbox=new HBox(10);
		hbox.getChildren().add(new Circle(150));
		hbox.getChildren().add(new Polygon(150,0,0,300,300,300));
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(grid,hbox);
		AnchorPane.setTopAnchor(hbox, 300.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(840);
		primaryStage.setWidth(1200);
		primaryStage.show();
	
		Rectangle rec1=(Rectangle)grid.getChildren().get(0);
		rec1.setFill(new ImagePattern(image));
		
		Rectangle rec2=(Rectangle)grid.getChildren().get(1);
		rec2.setFill(new ImagePattern(image,0,0,0.5,0.5,true));
		
		Rectangle rec3=(Rectangle)grid.getChildren().get(2);
		rec3.setFill(new ImagePattern(image,0,0,50,50,false));
		
		Rectangle rec4=(Rectangle)grid.getChildren().get(3);
		rec4.setFill(new ImagePattern(image,20,0,50,50,false));
		
		Circle circle=(Circle)hbox.getChildren().get(0);
		circle.setFill(new ImagePattern(image,50,0,100,100,false));
		//坐标从圆心开始计算
		
		Polygon pol=(Polygon)hbox.getChildren().get(1);
		pol.setFill(new ImagePattern(image,0,0,100,100,false));
	}
}
