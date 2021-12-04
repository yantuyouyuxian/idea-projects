/**
 * 
 */
package fx.com;

import java.util.function.Consumer;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
		HBox hbox=new HBox(200);
		hbox.setAlignment(Pos.CENTER);
		Button bu=new Button("button");
		Text text=new Text("this is text");
		text.setFont(new Font(30));
		Rectangle rec=new Rectangle(100,100,Paint.valueOf("#8470ff"));
		Circle circle=new Circle(50,Paint.valueOf("#ff69b4"));
		hbox.getChildren().addAll(bu,text,rec,circle);
		
		hbox.getChildren().forEach(new Consumer<Node>() {

			@Override
			public void accept(Node t) {
				// TODO Auto-generated method stub
				t.setEffect(getEffect());
			}
		});
		
	
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox);
		
		AnchorPane.setTopAnchor(hbox, 100.0);
		AnchorPane.setLeftAnchor(hbox, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(750);
		primaryStage.setWidth(1300);
		primaryStage.show();
	}
	
	public Effect getEffect() {
		
		Shadow sh=new Shadow();//�����Ӱ
		//��������Ӱ���ٵ���һ��ͬ�������
//		sh.setColor(Color.GREEN);
		
//		sh.setWidth(value);
//		sh.setHeight(value);
		
//		sh.setBlurType(BlurType.GAUSSIAN);
		
//		sh.setRadius(50);
		

		
		return sh;
	}
	

}
