/**
 * 
 */
package views;

import java.io.File;
import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import tools.MusicFileFromPath;

/**
 * @author Z H
 *
 */
public class SetFolderStage {
	
	double x=0,y=0;
	
	double width=300;
	double height=500;
	
	private Stage setstage;
	private Scene scene;
	private AnchorPane root;
	private ImageView iv_close;
	private VBox vbox;
	private ListView<File> list;
	private ImageView iv_add;
	
	public SetFolderStage() throws IOException {
		
		initial();
		
	}
	
	
	
	public Stage getSetstage() {
		
		return setstage;
		
	}

	public void initial() throws IOException {

		//关闭图标----------------------------------------------------------------------
		Image close_w=new Image("icon_white/close.png");
		Image close_b=new Image("icon_black/close.png");
		iv_close=new ImageView(close_w);
		iv_close.setPickOnBounds(true);
		iv_close.setFitWidth(20);
		iv_close.setPreserveRatio(true);
		
		iv_close.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_close.setImage(close_b);
				}
				if(newValue == false) {
					iv_close.setImage(close_w);
				}
			}
		});
		
		iv_close.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setstage.close();
				}
			}
		});
		
		//目录列表---------------------------------------------------------------------
		vbox=new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		
		list=new ListView<File>(MusicFileFromPath.getDirsList());
		list.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		
		list.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {

			@Override
			public ListCell<File> call(ListView<File> param) {
				// TODO Auto-generated method stub
				ListCell<File> cell = new ListCell<File>() {

					@Override
					protected void updateItem(File item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if (empty == false && item != null) {
							
							Text text = new Text(item.getPath());
							text.setFill(Color.WHITE);
							text.setTextAlignment(TextAlignment.CENTER);
							text.setWrappingWidth(290);
							text.setFont(Font.font(16));

							this.setAlignment(Pos.CENTER);
							this.setGraphic(text);
							this.setOpacity(1);
							this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
						} else {
							this.setGraphic(null);
							this.setOpacity(0);
						}
					}
				};
				
				MenuItem mi1 = new MenuItem("从列表中移除");
				ContextMenu cm = new ContextMenu(mi1);
				cell.setContextMenu(cm);
				
				mi1.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						try {
							System.out.println(MusicFileFromPath.getDirsList().get(cell.getIndex()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							MusicFileFromPath.deleteDir(MusicFileFromPath.getDirsList().get(cell.getIndex()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				return cell;
			}
		});

		list.setFixedCellSize(50);
		
		//添加目录-------------------------------------------------------------
		Image add_w=new Image("icon_white/add.png");
		Image add_b=new Image("icon_black/add.png");
		iv_add=new ImageView(add_w);
		iv_add.setPickOnBounds(true);
		iv_add.setFitWidth(50);
		iv_add.setPreserveRatio(true);
		
		iv_add.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_add.setImage(add_b);
				}
				if(newValue == false) {
					iv_add.setImage(add_w);
				}
			}
		});
		
		iv_add.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					DirectoryChooser dc = new DirectoryChooser();
					Stage stage = new Stage();
					dc.setTitle("选择文件夹");
					File file = dc.showDialog(stage);
					try {
						if (file != null && MusicFileFromPath.getDirsList().contains(file)==false) {
							System.out.println("添加文件夹： " + file.getAbsolutePath());
							MusicFileFromPath.addDir(file);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		//根节点布局-----------------------------------
		root=new AnchorPane();
		// 圆角矩形
		Rectangle bgclip = new Rectangle();
		bgclip.setArcHeight(30);
		bgclip.setArcWidth(30);
		
		// 背景图片
		ImageView bg = new ImageView("img/bg2.jpg");
		bg.setSmooth(true);
		bg.setClip(bgclip);
		
		// 绑定圆角图片和根节点的宽高
		bg.fitWidthProperty().bind(root.widthProperty());
		bg.fitHeightProperty().bind(root.heightProperty());
		bgclip.widthProperty().bind(root.widthProperty());
		bgclip.heightProperty().bind(root.heightProperty());
		
		root.setBackground(new Background(new BackgroundFill(null, new CornerRadii(20), null)));
		root.setBorder(new Border(new BorderStroke(null, null, new CornerRadii(20), null)));
		
		vbox.getChildren().addAll(list,iv_add);
		
		root.getChildren().addAll(bg,iv_close,vbox);
		
		AnchorPane.setRightAnchor(iv_close, 2.0);
		AnchorPane.setTopAnchor(iv_close, 2.0);
		
		AnchorPane.setTopAnchor(vbox, 25.0);
		AnchorPane.setLeftAnchor(vbox, 0.0);
		AnchorPane.setRightAnchor(vbox, 0.0);
		
		scene=new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		
		setstage = new Stage();
		setstage.setScene(scene);
		
		setstage.setWidth(350);
		setstage.setHeight(500);
		setstage.initStyle(StageStyle.TRANSPARENT);

		scene.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				x = event.getX();
				y = event.getY();

			}
		});
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setstage.setX(event.getScreenX() - x);
				setstage.setY(event.getScreenY() - y);
			}
		});

	}
	

}
