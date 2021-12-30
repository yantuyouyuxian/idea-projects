/**
 * 
 */
package views;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class TopView extends HBox{

	
	private Stage primaryStage;
	
	private  double gap=20;
	
	private  double width=20;
	
	private  HBox hbox;
	private  ImageView iv_close;
	private  ImageView iv_min ;
	private  ImageView iv_full ;
	
	private SystemTray systemtray;
	private java.awt.Image image;
	private PopupMenu menu;
	private MenuItem item;
	private TrayIcon tray;
	
	public TopView(Stage stage) {
		
		this.primaryStage=stage;
		
		initial();
	}
	
	
	public  void initial() {

		Image close = new Image("icon_white/close.png");
		Image full = new Image("icon_white/full.png");
		Image min = new Image("icon_white/min.png");
		Image normal = new Image("icon_white/normal.png");

		iv_close = new ImageView(close);
		
		iv_min = new ImageView(min);
		
		iv_full = new ImageView(full);
		
		//最小化
		iv_min.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					primaryStage.setIconified(true);
				}
			}
		});
		
		//全屏
		iv_full.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					primaryStage.setFullScreen(!primaryStage.isFullScreen());
				}
			}
		});
		
		Platform.setImplicitExit(false);
		systemtray=SystemTray.getSystemTray();
		image=Toolkit.getDefaultToolkit().getImage("src/img/trayicon.png");
		menu=new PopupMenu();
		item=new MenuItem("退出");
		menu.add(item);
		tray=new TrayIcon(image, "musicPlayer", menu);
		//关闭
		iv_close.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY)) {
//					primaryStage.close();		
					primaryStage.hide();
					// TODO Auto-generated method stub
				
					try {
						systemtray.add(tray);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					tray.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseClicked(java.awt.event.MouseEvent e) {
							// TODO Auto-generated method stub

							// TODO Auto-generated method stub
							if(e.getClickCount()==2) {
								
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
						public void mousePressed(java.awt.event.MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(java.awt.event.MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseEntered(java.awt.event.MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(java.awt.event.MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
					item.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// TODO Auto-generated method stub
							systemtray.remove(tray);
							Platform.runLater(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									Platform.setImplicitExit(true);
									Platform.exit();
								}
							});
							
						}
					});
					
					
				}
			}
		});

		//全屏修改图标
		primaryStage.fullScreenProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_full.setImage(normal);
				}
				if(newValue == false) {
					iv_full.setImage(full);
				}
			}
		});
		
		//----------------------------------------------------------------------------------------------
		hbox = new HBox(gap);
		
		hbox.setTranslateY(-25);
		
		hbox.setPrefHeight(50);
		// hbox.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		hbox.getChildren().addAll(iv_min, iv_full, iv_close);
		hbox.getChildren().forEach(node->{
			ImageView iv=(ImageView)node;
			iv.setPickOnBounds(true);
			iv.setFitWidth(width);
			iv.setPreserveRatio(true);
		});
		//-------------------------------------------------------------------------------
		//位移动画
		TranslateTransition tt=new TranslateTransition(Duration.seconds(0.5), hbox);
		hbox.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tt.setFromY(-25);
				tt.setToY(0);
				tt.play();
			}
		});
		hbox.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tt.setFromY(0);
				tt.setToY(-25);
				tt.play();
			}
		});
	}
	
	public  HBox getTopView() {
		
		return hbox;
		
	}

}
