/**
 * 
 */
package fx.com;

import java.nio.file.attribute.PosixFilePermission;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.PopupWindow.AnchorLocation;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		AnchorPane an=new AnchorPane();
		Button b1=new Button("button");
		
		Tooltip tip=new Tooltip("tooltip123456789wearfaerweaar");
		tip.setFont(new Font(20));
		tip.setPrefWidth(300);
		tip.setPrefHeight(180);
		tip.setTextAlignment(TextAlignment.CENTER);
		tip.setWrapText(true);
//		tip.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
		
//		tip.setAnchorLocation(AnchorLocation.CONTENT_TOP_LEFT);
		
		b1.setTooltip(tip);
		
//		Tooltip.uninstall(b1, tip);
//		Tooltip.install(b1, tip);
		
//		tip.setAutoHide(true);
		
		tip.setOnShown(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				System.out.println("shown");
			}
		});
		
		tip.setOnShowing(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				System.out.println("showing");
			}
		});
		
		tip.setOnHidden(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				System.out.println("hiden");
			}
		});
		
		tip.setOnHiding(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				System.out.println("hiding");
			}
		});
		
		an.getChildren().addAll(b1);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
//		tip.show(primaryStage);
//		tip.setX(100);
//		tip.setY(100);
		
//		tip.setAnchorX(100);
//		tip.setAnchorY(100);
	}

}
