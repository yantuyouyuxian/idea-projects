/**
 * 
 */
package fx.com;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Mnemonic;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	ImageView iv;
	Stage primary;
	Stage stage;
	
	double x1,y1;
	double x2,y2;
	
	HBox view;
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
		
		primary=primaryStage;
		Button bu=new Button("点击截图");
		
		iv=new ImageView();
		iv.setFitWidth(400);
		iv.setPreserveRatio(true);
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,iv);
		
		AnchorPane.setTopAnchor(iv, 100.0);
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ScreenShot");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				show();
			}
		});
		
		KeyCombination key=KeyCombination.valueOf("ctrl+alt+P");
		Mnemonic mc=new Mnemonic(bu, key);
		scene.addMnemonic(mc);
		
	}
	
	public void show() {
		primary.setIconified(true);//最小化
		
		
		AnchorPane an=new AnchorPane();
		an.setStyle("-fx-background-color:#11111120");
		
		Scene scene=new Scene(an);
		scene.setFill(Paint.valueOf("#00000000"));
		
		stage=new Stage();
		stage.setScene(scene);
		stage.setFullScreenExitHint("");
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
		
		stage.setFullScreen(true);
		
		drag(an);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode() == KeyCode.ESCAPE) {
					stage.close();
					primary.setIconified(false);
				}
			}
		});
		
	}
	
	public void drag(AnchorPane an) {
		
		Label label=new Label();
		Button bu=new Button("确定");
		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					try {
						getScreenImg();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		an.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				an.getChildren().clear();
				an.getChildren().add(label);
				view=new HBox();
				view.setBackground(null);
				view.setBorder(
						new Border(
								new BorderStroke(Paint.valueOf("red"), BorderStrokeStyle.SOLID, null, new BorderWidths(2), null)));
				
				x1=event.getSceneX();
				y1=event.getSceneY();
				
				System.out.println(x1+"  "+y1);
				
				an.getChildren().add(view);
				
				AnchorPane.setTopAnchor(view, y1);
				AnchorPane.setLeftAnchor(view, x1);
			}
		});
		
		an.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				an.startFullDrag();
			}
		});
		
		an.setOnMouseDragOver(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
				label.setStyle("-fx-background-color:black");
				label.setTextFill(Paint.valueOf("white"));
				label.setAlignment(Pos.CENTER);
				label.setPrefHeight(30);
				label.setPrefWidth(100);
				
				AnchorPane.setTopAnchor(label, y1-label.getPrefHeight());
				AnchorPane.setLeftAnchor(label, x1);
				
				x2=event.getSceneX();
				y2=event.getSceneY();
				
				double width=x2-x1;
				double height=y2-y1;
				
				view.setPrefWidth(width);
				view.setPrefHeight(height);
				
				label.setText(width+"*"+height);
			}
		});
		
		an.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				// TODO Auto-generated method stub
				x2=event.getSceneX();
				y2=event.getSceneY();
				an.getChildren().add(bu);
				
				AnchorPane.setTopAnchor(bu, y2);
				AnchorPane.setLeftAnchor(bu, x2-40);
				
				System.out.println(bu.getWidth());
				
				
			}
		});
		
		
	}
	public void getScreenImg() throws AWTException, IOException {
		
		stage.close();
		
		int w=(int) (x2-x1);
		int h=(int) (y2-y1);
		
		Robot robot=new Robot();
		
		Rectangle rec=new Rectangle((int)x1, (int)y1, w, h);
		
		BufferedImage buffimg=robot.createScreenCapture(rec);
		
		WritableImage wi=SwingFXUtils.toFXImage(buffimg, null);
		
		iv.setImage(wi);
		
		
		
		Clipboard cb=Clipboard.getSystemClipboard();
		
		ClipboardContent content=new ClipboardContent();
		
		content.putImage(wi);
		cb.setContent(content);
		
		ImageIO.write(buffimg, "png", new File("E:\\Users\\Z H\\Desktop\\sc.png"));
		
		primary.setIconified(false);
		
	}
	

}
