package views;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SetView {
	
	private VBox vbox;
	
	private ImageView iv_folder;
	
	private double iconwidth=30;
	
	private double xtran=-32;
	
	private SimpleBooleanProperty isshowing=new SimpleBooleanProperty(false);
	
	private TranslateTransition tt;
	
	
	public SetView() {
		
		initial();
		
	}

	public void initial() {
		
		Image folder_w=new Image("icon_white/addfolder.png");
		Image folder_b=new Image("icon_black/addfolder.png");
		
		vbox=new VBox(5);
		
		
		
		iv_folder=new ImageView(folder_w);
		
		Tooltip tp=new Tooltip("设置音乐文件目录");
		Tooltip.install(iv_folder, tp);
		
		iv_folder.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_folder.setImage(folder_b);
				}
				if(newValue == false) {
					iv_folder.setImage(folder_w);
				}
			}
		});
		
		tt=new TranslateTransition(Duration.seconds(0.2), vbox);
		
		vbox.getChildren().addAll(iv_folder);
		
		vbox.setTranslateX(xtran);
		
		vbox.getChildren().forEach(node ->{
			try {
				ImageView iv = (ImageView) node;
				iv.setPickOnBounds(true);
				iv.setFitWidth(iconwidth);
				iv.setPreserveRatio(true);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("vbox_icon");
			}
		});
		
//		vbox.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
		isshowing.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					show();
				}
				if(newValue == false) {
					hide();
				}
			}
		});
	}
	
	public void show() {

		tt.setFromX(xtran);
		tt.setToX(0);
		tt.play();

	}

	public void hide() {

		tt.setFromX(0);
		tt.setToX(xtran);
		tt.play();

	}
	
	public VBox getSetView() {
		return vbox;
	}
	
	public ImageView getIv_folder() {
		return iv_folder;
	}

	public SimpleBooleanProperty getIsshowing() {
		return isshowing;
	}


}
