/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
		
		Text text1=new Text("hello world");
		Font font1=new Font("Courier", 20);
		text1.setFont(font1);
		
		Text text2=new Text("hello world");
		Font font2=new Font("Impact", 25);
		text2.setFont(font2);
		
		Text text3=new Text("你好，世界");
		Font font3=Font.loadFont("file:/C:/Windows/Fonts/simkai.ttf", 30);
		text3.setFont(font3);
		
		Font.getFamilies().forEach(item->System.out.println(item));
		System.out.println("-----------------------------------------------");
//		Font.getFontNames().forEach(item->System.out.println(item));
		
		Text text4=new Text("hello world");
		Font font4=Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 25);
		text4.setFont(font4);
		
		Text text5=new Text("hello world");
		Font font5=new Font("Courier", 60);
		text5.setFont(font5);
		text5.setFill(Paint.valueOf("red"));
		text5.setStroke(Paint.valueOf("white"));
		text5.setStrokeWidth(2);
		text5.setSmooth(true);
		text5.setUnderline(true);
		text5.setStrikethrough(true);//中间线
		text5.setFontSmoothingType(FontSmoothingType.LCD);//字体平滑
		
		
		Text text6=new Text("abcdefg\nhijklmn\nopqrstuvwxyz");
		Font font6=new Font("Courier", 25);
		text6.setFont(font6);
		text6.setTextAlignment(TextAlignment.CENTER);
		text6.setLineSpacing(10);
//		text6.setWrappingWidth(200);//用像素限制宽度
		
		
		VBox vbox=new VBox(20);
		vbox.setPrefWidth(600);
		vbox.setPrefHeight(360);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color:yellow");
		vbox.getChildren().addAll(text1,text2,text3,text4,text5,text6);
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(vbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
	}

}
