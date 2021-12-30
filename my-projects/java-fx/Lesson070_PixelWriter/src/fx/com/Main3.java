package fx.com;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main3 extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane an=new AnchorPane();
		
		Image image=new Image("file:C:\\Users\\zh\\Desktop/sig.jpg");
		ImageView iv=new ImageView();
		iv.prefWidth(image.getWidth());
		iv.prefHeight(image.getHeight());
		iv.setImage(image);
		System.out.println(image.getWidth());
		System.out.println(image.getHeight());
		
//		WritableImage wi=new WritableImage(200, 200);
		WritableImage wi=new WritableImage(528, 248);
		
		PixelReader pr=image.getPixelReader();
		PixelWriter pw=wi.getPixelWriter();
		
		Color color=pr.getColor(527, 247);
		System.out.println(color.equals(Color.WHITE));
		System.out.println((int)(color.getRed()*255));
		System.out.println((int)(color.getGreen()*255));
		System.out.println((int)(color.getBlue()*255));
		System.out.println((int)(color.getOpacity()*255));
		
		for(int i=0;i<image.getWidth();i++) {
			for(int j=0;j<image.getHeight();j++) {
				pw.setColor(i, j, new Color(1,1,1,1));
			}
		}
		
		for(int i=0;i<image.getWidth();i++) {
			for(int j=0;j<image.getHeight();j++) {
				Color c=pr.getColor(i, j);
				if(c.equals(Color.WHITE)) {
					continue;
				}else {
					for(int a=i;a>i-20;a--) {
						for(int b=j;b>j-30;b--) {
							pw.setColor(a, b, c);
						}
					}
				}
				
			}
		}
		
		BufferedImage buff=SwingFXUtils.fromFXImage(wi, null);
		
		ImageIO.write(buff, "png", new File("C:\\Users\\zh\\Desktop\\2001.png"));
		
		
		
		ImageView iv2=new ImageView();
		iv2.setImage(wi);
		iv2.prefWidth(528);
		iv2.prefHeight(248);
		
		an.getChildren().addAll(iv,iv2);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
