/**
 * 
 */
package fx.com;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
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
	
		GridPane gp=new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<5;j++) {
				Rectangle rec=new Rectangle(200,200);
				rec.setFill(Paint.valueOf("gray"));
				gp.add(rec, j, i);
			}
		}
		
		ArrayList<Paint> list=new ArrayList<>();
		
		Stop[] stops=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.5,Color.valueOf("#e7225e")),new Stop(1,Color.valueOf("#35da63"))};
		LinearGradient lg1=
				new LinearGradient(0, 0, 200, 200, false, CycleMethod.NO_CYCLE, stops);
		list.add(lg1);
		
		Stop[] stops2=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.3,Color.valueOf("#e7225e")),new Stop(0.6,Color.valueOf("#23c7d6")),new Stop(1,Color.valueOf("#35da63"))};
		LinearGradient lg2=
				new LinearGradient(0, 0, 200, 200, false, CycleMethod.NO_CYCLE, stops2);
		list.add(lg2);
		
		Stop[] stops3=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.3,Color.valueOf("#e7225e")),new Stop(0.6,Color.valueOf("#23c7d6")),new Stop(1,Color.valueOf("#35da63"))};
		LinearGradient lg3=
				new LinearGradient(0, 0, 200, 0, false, CycleMethod.NO_CYCLE, stops3);
		list.add(lg3);
		
		Stop[] stops4=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.3,Color.valueOf("#e7225e")),new Stop(0.6,Color.valueOf("#23c7d6")),new Stop(1,Color.valueOf("#35da63"))};
		LinearGradient lg4=
				new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops4);
		list.add(lg4);
		
		Stop[] stops5=new Stop[] {new Stop(0.3,Color.valueOf("#3238b0")),new Stop(0.7,Color.valueOf("#e7225e"))};
		LinearGradient lg5=
				new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops5);
		list.add(lg5);
		
		Stop[] stops6=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.5,Color.valueOf("#e7225e"))};
		LinearGradient lg6=
				new LinearGradient(0, 0, 0.3, 0, true, CycleMethod.REFLECT, stops6);//结束坐标不齐，自己重复
		list.add(lg6);
		
		Stop[] stops7=new Stop[] {new Stop(0,Color.valueOf("#3238b0")),new Stop(0.5,Color.valueOf("#e7225e"))};
		LinearGradient lg7=
				new LinearGradient(0, 0, 0.3, 0, true, CycleMethod.REPEAT, stops7);//复制填充
		list.add(lg7);
		
		for(int i=0;i<list.size();i++) {
			Rectangle rec=(Rectangle)gp.getChildren().get(i);
			rec.setFill(list.get(i));
		}
		
	
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(gp);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1100);
		primaryStage.show();
	
	}
}
