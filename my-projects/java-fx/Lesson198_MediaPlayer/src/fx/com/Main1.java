/**
 * 
 */
package fx.com;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.net.URLDecoder;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

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

		Platform.setImplicitExit(false);
		String http="http://ws.stream.qqmusic.qq.com/C4000027vODg1uLVlM.m4a?guid=1520352230&vkey=FF61D72FB868EB1568E15258721D5A4A5B7E0A22EF0544B83D3B71D9ED8437C0DDD531C0FB67D3A9743A8F3B7AD4196F564E9402BC8CD97C&uin=180&fromtag=66";
		
		URL url=this.getClass().getClassLoader().getResource("res/everytime.mp3");
//		URL url=this.getClass().getClassLoader().getResource("res/即使手中空无一物.mp3");
		System.out.println(url.toExternalForm());
		System.out.println(URLDecoder.decode(url.toExternalForm(), "UTF-8"));
		
//		Media media=new Media(url.toExternalForm());
		Media media=new Media(url.toExternalForm());
		
		MediaPlayer mp=new MediaPlayer(media);
		mp.setVolume(0.5);
//		mp.setAutoPlay(true);
//		mp.setBalance(0);
//		mp.setMute(true);
//		mp.setRate(2);
//		mp.setStartTime(Duration.seconds(50));
//		mp.setStopTime(Duration.seconds(60));
//		mp.setCycleCount(MediaPlayer.INDEFINITE);
//		mp.getCurrentTime();
		
//		mp.dispose();
		
		mp.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(media.getDuration().toSeconds());
				System.out.println(mp.getTotalDuration().toSeconds());
			}
		});
		
		
		Button bu1=new Button("play");
		Button bu2=new Button("stop");
		Button bu3=new Button("pause");
		Button bu4=new Button("tray");
		
		AnchorPane root = new AnchorPane();
		root.getChildren().addAll(bu1,bu2,bu3,bu4);
		AnchorPane.setLeftAnchor(bu2, 60.0);
		AnchorPane.setLeftAnchor(bu3, 120.0);
		AnchorPane.setLeftAnchor(bu4, 180.0);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.play();
			}
		});
		
		bu2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.stop();
			}
		});
		
		bu3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.pause();
				System.out.println(mp.getCurrentTime());
			}
		});
		
		bu4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				primaryStage.hide();
				// TODO Auto-generated method stub
				SystemTray systemtray=SystemTray.getSystemTray();
				
				Image image=Toolkit.getDefaultToolkit().getImage("src/icon/icon2.png");
				
				PopupMenu menu=new PopupMenu();
				MenuItem item=new MenuItem("退出");
				menu.add(item);
				TrayIcon tray=new TrayIcon(image, "musicPlayer", menu);
				
				try {
					systemtray.add(tray);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				tray.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if(e.getClickCount()==2) {
							System.out.println("22222");
							systemtray.remove(tray);
							
							Platform.runLater(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									primaryStage.show();
								}
							});
							
						}
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				item.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(java.awt.event.ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
				
			}
		});
		
	}

}
