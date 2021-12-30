/**
 * 
 */
package views;

import java.io.File;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import javafx.util.Duration;
import tools.MusicFileFromMySQL;

/**
 * @author Z H
 *
 */
public class MusicListView {
	
	private SimpleIntegerProperty playindex=new SimpleIntegerProperty(0);
	
	private SimpleBooleanProperty isshowing=new SimpleBooleanProperty(false);
	
	private AnchorPane anpane;
	
	private static ListView<File> listview;
	
	private TranslateTransition tt;
	
	private double width=400;
	
	private double height=500;
	
	private double xtran=401;
	
	public MusicListView() {
		
		
		
		initial();
		
	}
	
	public void initial() {
		
		anpane=new AnchorPane();
		
		listview=new ListView<File>(MusicFileFromMySQL.getMusicFiles());
		Text placehold=new Text("列表为空，点击设置添加音乐目录");
		placehold.setFill(Color.WHITE);
		placehold.setFont(Font.font(19));
		listview.setPlaceholder(placehold);
		listview.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		listview.setFixedCellSize(40);
		listview.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
			
			@Override
			public ListCell<File> call(ListView<File> param) {
				// TODO Auto-generated method stub
				
				ListCell<File> cell=new ListCell<File>() {
					@Override
					protected void updateItem(File item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if (empty == false && item != null) {
							
							StringBuffer sb=new StringBuffer(item.getName());
							
							Text text = new Text(sb.substring(0, sb.length()-4));
							text.setWrappingWidth(350);
							text.setTextAlignment(TextAlignment.CENTER);
							if(this.getIndex() == playindex.get()) {
								text.setFont(Font.font(19));
								text.setFill(Color.DEEPSKYBLUE);
							}else{
								text.setFont(Font.font(16));
								text.setFill(Color.WHITE);
							}
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
				MenuItem mi1=new MenuItem("从列表中移除");
				mi1.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						MusicFileFromMySQL.getMusicFiles().remove(cell.getIndex());
						MusicFileFromMySQL.getMusicMedias().remove(cell.getIndex());
					}
				});
				ContextMenu cm=new ContextMenu(mi1);
				cell.setContextMenu(cm);
				cell.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						if(event.getClickCount()==2 && event.getButton()==MouseButton.PRIMARY) {
							playindex.set(cell.getIndex());
						}
					}
				});
				
				playindex.addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						// TODO Auto-generated method stub
						if(newValue.intValue()==cell.getIndex()) {
							if(cell.getGraphic()!=null) {
								Text text=(Text)cell.getGraphic();
								text.setFont(Font.font(19));
								text.setFill(Color.DEEPSKYBLUE);
							}
						}else {
							if(cell.getGraphic()!=null) {
								Text text=(Text)cell.getGraphic();
								text.setFont(Font.font(16));
								text.setFill(Color.WHITE);
							}
							
						}
					}
				});
				
				return cell;
			}
		});
		
		listview.setPrefHeight(height);
		listview.setPrefWidth(width);
		
		anpane.setTranslateX(xtran);
		
		anpane.getChildren().add(listview);
		
		tt=new TranslateTransition(Duration.seconds(0.5), anpane);
		
		
		
		isshowing.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					show();
					listview.scrollTo(playindex.get());
				}
				if(newValue == false) {
					hide();
				}
			}
		});
	}
	
	public AnchorPane getMusicListView() {
		
		return anpane;
	}

	public void show() {
		
		tt.setFromX(xtran);
		tt.setToX(15);
		tt.play();
		
	}
	
	public void hide() {
		
		tt.setFromX(15);
		tt.setToX(xtran);
		tt.play();
		
	}
	
	
	
	public static ListView<File> getListview() {
		return listview;
	}

	public SimpleBooleanProperty getIsshowing() {
		return isshowing;
	}

	public SimpleIntegerProperty getPlayindex() {
		return playindex;
	}

}
