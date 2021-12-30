/**
 * 
 */
package fx.com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
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
		
		WritableImage wi=new WritableImage(100, 100);
		
		PixelWriter pw=wi.getPixelWriter();
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				pw.setColor(i, j, Color.valueOf("red"));
			}
		}
		
		for(int i=0;i<100;i++) {
			pw.setColor(i, i, Color.valueOf("blue"));
			
		}
		
		System.out.println("-----------------------------------------");
		
		Image image=new Image("file:E:\\Users\\Z H\\Desktop\\images/002.png",600,600,true,true);
		
		WritableImage wi2=new WritableImage(image.getPixelReader(), (int)image.getWidth(), (int)image.getHeight());
		
		PixelWriter pw2=wi2.getPixelWriter();
		
		for(int i=0;i<50;i++) {
			for(int j=0;j<50;j++) {
				pw2.setColor(i, j, Color.valueOf("red"));
			}
		}
		
		Image data=new Image("file:E:\\Users\\Z H\\Desktop\\images/001.jpeg",600,0,true,true);
		
		Image image2=new Image("file:E:\\Users\\Z H\\Desktop\\images/002.png",1000,0,true,true);
		
		WritableImage wi3=new WritableImage(image2.getPixelReader(),0,0, (int)image2.getWidth(), (int)image2.getHeight());
		
		PixelWriter pw3=wi3.getPixelWriter();
		
		PixelReader pr=data.getPixelReader();
		
		for(int i=0;i<600;i++) {
			for(int j=0;j<300;j++) {
				pw3.setColor(i, j, pr.getColor(i, j));
			}
		}
		
		System.out.println("-------------------------------------------");
		
		Image data2=new Image("file:E:\\Users\\Z H\\Pictures\\Saved Pictures/2.jpg");
		
		Image image3=new Image("file:E:\\Users\\Z H\\Pictures\\Saved Pictures/3.jpg");
		
		WritableImage wi4=new WritableImage(image3.getPixelReader(),(int)image3.getWidth(), (int)image3.getHeight());
		
		PixelWriter pw4=wi4.getPixelWriter();
		
		PixelReader pr2=data2.getPixelReader();
		
		WritablePixelFormat<IntBuffer> pixelformat=PixelFormat.getIntArgbPreInstance();
		
		int[] in=new int[1920*1080/2];
		
		pr2.getPixels(0, 0, 1920/2, 1080, pixelformat, in, 0, 1920/2);
		
//		pw4.setPixels(0, 0, 1920/2, 1080, pixelformat, in, 0, 1920/2);
		
		pw4.setPixels(0, 0, 1920/2, 1080, pr2, 500, 0);
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				pw4.setColor(i, j, Color.valueOf("#00000000"));
			}
		}
		
		System.out.println("---------------------------");
		
		BufferedImage bi=SwingFXUtils.fromFXImage(wi4, null);
		
		ImageIO.write(bi, "png", new File("D:/new.png"));
		
		System.out.println("-------------------------------");
		
		ImageView iv=new ImageView(wi4);
		Button bu=new Button("button");
//		WritableImage wbi=iv.snapshot(null, null);
//		
//		BufferedImage buff=SwingFXUtils.fromFXImage(wbi, null);
//		
//		ImageIO.write(buff, "png", new File("D:/newsnap.png"));
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(iv,bu);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		WritableImage wbi=bu.snapshot(null, null);
		
		BufferedImage buff=SwingFXUtils.fromFXImage(wbi, null);
		
		ImageIO.write(buff, "png", new File("D:/newbuttonsnap.png"));
	}

}
