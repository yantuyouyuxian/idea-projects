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
import javafx.scene.paint.Paint;
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
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				Rectangle rec=new Rectangle(150,150);
				rec.setFill(Paint.valueOf("white"));
				gp.add(rec, j, i);
			}
		}
		
		ArrayList<Color> list=new ArrayList<>();
		
		list.add(Color.valueOf("#ee6aa7"));
		list.add(Color.valueOf("#ee6aa755"));
		list.add(Color.valueOf("0xee6aa7"));
		list.add(Color.PINK);
		list.add(Color.BLUE);
		
		list.add(new Color(140.0/255, 36.0/255, 200.0/255, 0.5));
		list.add(new Color(140.0/255, 36.0/255, 200.0/255, 1));
		list.add(Color.rgb(30, 175, 217, 1));
		list.add(Color.hsb(180, 1, 1, 1));
		//色相，饱和度，明亮度，透明度
		Color color=Color.rgb(34, 212, 143,1);
		list.add(color.deriveColor(100, 1, 1, 1));//derive;获取，得自
		
		list.add(Color.web("rgb(255,255,50%)", 1));
		list.add(Color.gray(0.5, 1));
		list.add(Color.grayRgb(50, 1));
		list.add(Color.rgb(54, 105, 198,1));
		list.add(Color.rgb(54, 105, 198,1).brighter());
		
		list.add(Color.rgb(54, 105, 198,1).darker());
		list.add(Color.rgb(54, 105, 198,1).saturate());
		list.add(Color.rgb(54, 105, 198,1).desaturate());
		list.add(Color.rgb(54, 105, 198,1).grayscale());
		list.add(Color.rgb(54, 105, 198,1).invert());
		
		
		
		for(int i=0;i<list.size();i++) {
			Rectangle rec=(Rectangle)gp.getChildren().get(i);
			rec.setFill(list.get(i));
		}
		
		System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue()+" "+color.getOpacity());
		
		System.out.println(color.getHue()+" "+color.getSaturation()+" "+color.getBrightness());
		
		System.out.println(color.isOpaque());//opaque;不透明得
		
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(gp);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(840);
		primaryStage.setWidth(820);
		primaryStage.show();
	
		
		
	}
}
