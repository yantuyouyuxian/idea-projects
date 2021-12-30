package fx.com;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Screen¿‡
 * @author Z H
 *
 */
public class Main1 extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Screen screen=Screen.getPrimary();
		
		Rectangle2D rec1=screen.getBounds();
		
		Rectangle2D rec2=screen.getVisualBounds();
		
		System.out.println("screen.getBounds()");
		System.out.println("x1="+rec1.getMinX()+" x2="+rec1.getMaxX());
		System.out.println("y1="+rec1.getMinY()+" y2="+rec1.getMaxY());
		
		System.out.println("screen.getVisualBounds()");
		System.out.println("x1="+rec2.getMinX()+" x2="+rec2.getMaxX());
		System.out.println("y1="+rec2.getMinY()+" y2="+rec2.getMaxY());
		
		System.out.println("screen.getDpi");
		System.out.println("DPI="+screen.getDpi());
		
		Platform.exit();
	}

}
