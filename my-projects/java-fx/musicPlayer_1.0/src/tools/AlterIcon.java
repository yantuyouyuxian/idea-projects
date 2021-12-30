/**
 * 
 */
package tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class AlterIcon extends Application{

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ImageView iv=new ImageView(); 
		
		Button bu=new Button("开始");
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(iv,bu);
		AnchorPane.setLeftAnchor(iv, 100.0);
		AnchorPane.setTopAnchor(iv, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		File dir=new File("C:\\Users\\23661\\Pictures\\icons");
		File[]	icons=dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith("png")) {
					return true;
				}else {
					return false;
				}
			}
		});
		
//		iv.setImage(new Image(icons[0].toURL().toExternalForm()));
		
		for(int i=0;i<icons.length;i++) {
			@SuppressWarnings("deprecation")
			URL url=icons[i].toURL();
//			System.out.println(url.toExternalForm());
			Image image=new Image(url.toExternalForm());
			
			int w=(int)image.getWidth();
			int h=(int)image.getHeight();
			
			PixelReader pr=image.getPixelReader();
			WritableImage wi=new WritableImage(pr, w, h);
			PixelWriter pw=wi.getPixelWriter();

			for(int j=0;j<w;j++) {//列
				for(int k=0;k<h;k++) {//行
					Color color=pr.getColor(j, k);
					double opa=color.getOpacity();;
					if(opa!=0) {
						pw.setColor(j, k, Color.WHITE);
					}
				}
			}
			BufferedImage buff=SwingFXUtils.fromFXImage(wi, null);
			
			try {
				StringBuffer sb=new StringBuffer(icons[i].getPath());
				System.out.println("sb "+sb);
//				System.out.println(sb.insert(sb.length()-4, '1'));
				String name=sb.insert(sb.length()-4, "1").toString();
				System.out.println("name "+name);
				ImageIO.write(buff, "png", new File(name));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
