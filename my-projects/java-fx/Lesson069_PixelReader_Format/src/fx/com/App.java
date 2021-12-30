package fx.com;

import java.nio.ByteBuffer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		String path="file:C:\\Java\\eclipse-workspace\\Lesson69_PixelReader_Format\\src\\images\\red.jpg";
		Image image=new Image(path);
		
		PixelReader pr=image.getPixelReader();
		
		System.out.println(pr.getPixelFormat().getType());
		
		int value=pr.getArgb(0, 0);
		
		int alpha=(value>>24) & 0xff;
		int red=(value>>16) & 0xff;
		int green=(value>>8) & 0xff;
		int blue=value & 0xff;
		
		System.out.println("alph:"+alpha+" r:"+red+" g:"+green+" b:"+blue);
//		System.out.println("r:"+red+" g:"+green+" b:"+blue);
		
		System.out.println(Integer.toHexString(value));
		
		
		System.out.println("---------------------");
		
		Color color=pr.getColor(0, 0);
//		color.getBlue()
//		color.getRed()
//		color.getGreen()
//		color.getOpacity()
		System.out.println(color.toString());
		
		System.out.println(Integer.parseInt("ff", 16));
		
		
		System.out.println("---------------------");
		
		
		WritablePixelFormat<ByteBuffer> pixelformat=PixelFormat.getByteBgraPreInstance();
		
		byte[] by=new byte[36];
		
		pr.getPixels(0, 0, 3, 3, pixelformat, by, 0, 12);
		
		
		for(int i=0;i<by.length;i=i+4) {
			int a=by[i+3] & 0xff;
			int r=by[i+2] & 0xff;
			int g=by[i+1] & 0xff;
			int b=by[i] & 0xff;
			
			System.out.println("a:"+a+" r:"+r+" g:"+g+" b:"+b);
		}
		
//		PixelFormat<ByteBuffer> pf=PixelFormat.getByteRgbInstance();
		
		
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

}
