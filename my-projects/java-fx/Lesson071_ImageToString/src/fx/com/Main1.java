/**
 * 
 */
package fx.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
		String path="file:E:\\Users\\Z H\\Desktop\\images/tou.jpg";
		Image image=new Image(path,600,250,false,true);
		System.out.println(image.getWidth()+"*"+image.getHeight());
		PixelReader pr=image.getPixelReader();
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<image.getHeight();i++) {
			for(int j=0;j<image.getWidth();j++) {
				Color color=pr.getColor(j, i);
				int value=(int)(color.getRed()*255);
				char ch=getChar(value);
//				System.out.println(ch);
				sb.append(ch);
			}
			sb.append("\r\n");
		}
		
		writeString(sb);
		
		
		ImageView iv=new ImageView(image);
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(iv);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		
	}
	//越白，rgb越大，越黑，rgb值越小
	public char getChar(int value) {
		char ch=' ';
		switch (value / 10) {
		//@ % & $ M # 
		case 0:
			ch='@';
			break;
		case 1:
			ch='%';
			break;
		case 2:
			ch='&';
			break;
		case 3:
			ch='$';
			break;
		case 4:
			ch='M';
			break;
		case 5:
			ch='#';
			break;
		// H K U P O C
		case 6:
			ch='H';
			break;
		case 7:
			ch='K';
			break;
		case 8:
			ch='U';
			break;
		case 9:
			ch='P';
			break;
		case 10:
			ch='O';
			break;
		case 11:
			ch='C';
			break;
		// L ? l ! = + 
		case 12:
			ch='L';
			break;
		case 13:
			ch='?';
			break;
		case 14:
			ch='l';
			break;
		case 15:
			ch='!';
			break;
		case 16:
			ch='=';
			break;
		case 17:
			ch='+';
			break;
		// ^ ; : - , .
		case 18:
			ch='^';
			break;
		case 19:
			ch=';';
			break;
		case 20:
			ch=':';
			break;
		case 21:
			ch='-';
			break;
		case 22:
			ch=',';
			break;
		case 23:
			ch='.';
			break;
		case 24:
			ch=' ';
			break;
		default:
			ch=' ';
			break;
		}
		return ch;
	}
	
	public void writeString(StringBuffer sb) throws Exception{
		File file=new File("E:\\Users\\Z H\\Desktop/aa.txt");
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.close();
		fw.close();
	}

}
