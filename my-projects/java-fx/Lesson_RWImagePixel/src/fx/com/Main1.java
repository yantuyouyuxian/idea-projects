/**
 * 
 */
package fx.com;

import javafx.application.Application;
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
import javafx.scene.layout.HBox;
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
		HBox hbox=new HBox(20);
		Button b1=new Button("解析");
		Button b2=new Button("还原");
		Button b3=new Button("变亮");
		Button b4=new Button("变暗");
		hbox.getChildren().addAll(b1,b2,b3,b4);
		
		Image image=new Image("img/red.jpg");
		int w=(int)image.getWidth();
		int h=(int)image.getHeight();
		
		ImageView iv=new ImageView(image);
		
		PixelReader pr=image.getPixelReader();
		
		WritableImage wi=new WritableImage(pr, w, h);
		
		PixelWriter pw=wi.getPixelWriter();
		
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(hbox,iv);
		AnchorPane.setLeftAnchor(iv, 100.0);
		AnchorPane.setTopAnchor(iv, 100.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for(int i=0;i<w;i++) {//列
					for(int j=0;j<h;j++) {//行
						Color color=pr.getColor(i, j);
						double opa=color.getOpacity();;
						int r=(int)(color.getRed()*255);
						int g=(int)(color.getGreen()*255);
						int b=(int)(color.getBlue()*255);
						if(r!=0 && g!=0 && b!=0) {
							int temp_r=r+50;
							int temp_g=g+50;
							int temp_b=b+50;
							
							if(temp_r>255) {
								temp_r=255;
							}
							if(temp_g>255) {
								temp_g=255;
							}
							if(temp_b>255) {
								temp_b=255;
							}
	
							Color temp=Color.rgb(temp_r, temp_g, temp_b,opa);
							pw.setColor(i, j, temp);
						}
					}
				}
				iv.setImage(wi);
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				iv.setImage(image);
			}
		});
		
		b3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		b4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for(int i=0;i<w;i++) {//列
					for(int j=0;j<h;j++) {//行
						Color color=pr.getColor(i, j);
						pw.setColor(i, j, color.brighter());
					}
				}
			}
		});

		
		b4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for (int i = 0; i < w; i++) {// 列
					for (int j = 0; j < h; j++) {// 行
						Color color = pr.getColor(i, j);
						pw.setColor(i, j, color.darker());
					}
				}
			}
		});
		
	}

}
