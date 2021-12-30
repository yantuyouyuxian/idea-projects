/**
 * 
 */
package fx.com;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main4 extends Application{

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
		AnchorPane an=new AnchorPane();
		
		String path="file:C:\\Java\\eclipse-workspace\\Lesson68_ImageView\\src\\images\\001.jpeg";
		Image image=new Image(path,500,0,true,true);
		System.out.println("image:"+image.getWidth()+" * "+image.getHeight());
		
		
		ImageView iv=new ImageView(image);
		iv.setFitWidth(500);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
		iv.setImage(image);
		
//		Rectangle2D rec2d=new Rectangle2D(0, 0, 500, 500);
//		iv.setViewport(rec2d);
	
//		iv.setOnMouseDragged(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				// TODO Auto-generated method stub
//				if(event.getSceneX() > 500-200 || event.getSceneY()>281-200) {
//					return;
//				}
//				Rectangle2D rec2d=new Rectangle2D(event.getSceneX(), event.getSceneY(), 200, 200);
//				iv.setViewport(rec2d);
//			}
//		});
		ScrollPane sp=new ScrollPane();
		sp.setPrefSize(200, 200);
		sp.setContent(iv);
		
		an.getChildren().addAll(sp);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
	}

}
