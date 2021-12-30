package views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import tools.MusicFileFromPath;

public class BottomView {

	private ObservableList<File> files;

//	private ObservableList<Media> medias;

	private Media media;

	private MediaPlayer mp;

	private Random ran=new Random();

	private SimpleDoubleProperty playprogress=new SimpleDoubleProperty(0);//进度

	private SimpleIntegerProperty playindex=new SimpleIntegerProperty(0);//

	private SimpleIntegerProperty cycletype=new SimpleIntegerProperty(0);

	private SimpleBooleanProperty isplaying=new SimpleBooleanProperty(false);

	private StringBuffer sb;

	//组件
	private AnchorPane anpane;
	private Label label_name;
	private Label label_time;
	private VBox vbox;

	private AnchorPane an;
	private Rectangle rec_progress;

	private double iconheight=30;
	private HBox hbox_icon;
	private ImageView iv_set;
	private ImageView iv_cycle;
	private ImageView iv_last;
	private ImageView iv_play;
	private ImageView iv_next;
	private ImageView iv_list;
	private ImageView iv_vol;
	private Slider sl_vol;

	private Spectrum st;
	private HBox spectrum;

	public BottomView() throws IOException {

		initial();

	}

	public void initial() throws IOException {

		String str="file:"+System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/";

		files=MusicFileFromPath.getMusicFiles();

//		medias=MusicFileFromPath.getMusicMedias();

//		medias.addListener(new ListChangeListener<Media>() {
//
//			@Override
//			public void onChanged(Change<? extends Media> c) {
//				// TODO Auto-generated method stub
//				while(c.next()) {
//					if(c.wasAdded()) {
////					mp=new MediaPlayer(medias.get(playindex.get()));
//
//					}
//					if(medias.size()==0) {
//						isplaying.set(false);
//						mp.pause();
//						mp=null;
//					}
//				}
//			}
//		});

		files.addListener(new ListChangeListener<File>() {

			@Override
			public void onChanged(Change<? extends File> c) {
				// TODO Auto-generated method stub
				while(c.next()) {
					if(c.wasAdded() && mp==null) {

//						mp=new MediaPlayer(medias.get(playindex.get()));

						media=new Media(files.get(playindex.get()).toURI().toASCIIString());
						mp=new MediaPlayer(media);

					}
					if(files.size()==0) {
						isplaying.set(false);
						mp.pause();
						mp=null;
					}
				}
			}
		});

//		if(medias.size()==0) {
//			mp=null;
//			sb=new StringBuffer("");
//		}else {
////			mp=new MediaPlayer(medias.get(playindex.get()));
//
//			media=new Media(files.get(playindex.get()).toURI().toASCIIString());
//			mp=new MediaPlayer(media);
//
//			sb=new StringBuffer(files.get(playindex.get()).getName());
//			sb=new StringBuffer(sb.substring(0, sb.length()-4));
//		}

		if(files.size()==0) {
			mp=null;
			sb=new StringBuffer("");
		}else {
//			mp=new MediaPlayer(medias.get(playindex.get()));

			media=new Media(files.get(playindex.get()).toURI().toASCIIString());
			mp=new MediaPlayer(media);

			sb=new StringBuffer(files.get(playindex.get()).getName());
			sb=new StringBuffer(sb.substring(0, sb.length()-4));
		}




		//监听playindex,改变了就重新播放
		playindex.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				myPlay();
			}
		});

		//总布局anpane
		anpane=new AnchorPane();

		//频谱
		st=new Spectrum();
		spectrum=st.getHbox();

		//-------------------------------------------------------------------
		//两个标签
		label_name=new Label();

		label_name.setText(sb.toString());
		label_name.setFont(new Font(15));
		label_name.setTextFill(Color.WHITE);
		label_name.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));

		label_time=new Label();
		label_time.setFont(new Font(12));
		label_time.setTextFill(Color.WHITE);
		label_time.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));



		//布局vbox-------------------------------------------------------------------
		vbox=new VBox();


		//-------------------------------------------------------------------
		// 进度条
		an = new AnchorPane();
		an.setPadding(new Insets(-1, 0, -1, 0));
		an.setBorder(new Border(
				new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
		rec_progress = new Rectangle(0, 3);
		rec_progress.setFill(Color.DEEPSKYBLUE);
		an.getChildren().add(rec_progress);
		// 进度条变换
		an.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if (newValue == true) {
					rec_progress.setHeight(6);
				}
				if (newValue == false) {
					rec_progress.setHeight(3);
				}
			}
		});
		// 点击进度条，调整矩形宽度和播放时间
		an.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton().equals(MouseButton.PRIMARY) && mp !=null) {
					rec_progress.widthProperty().unbind();
					rec_progress.setWidth(event.getX());
					mp.seek(Duration.seconds(event.getX() / an.getWidth() * mp.getTotalDuration().toSeconds()));
					rec_progress.widthProperty().bind(an.widthProperty().multiply(playprogress));
				}
			}
		});

		//----------------------------------------------------------------------------------------------------------------
		// 图标容器
		hbox_icon = new HBox();

		hbox_icon.setAlignment(Pos.CENTER);

		//----------------------------------------------------------------------------------------------------------------

		Image set_w=new Image(str+"icon_white/set.png");
		Image set_b=new Image(str+"icon_black/set.png");

		ArrayList<Image> cycle=new ArrayList<>();
		cycle.add(new Image(str+"icon_white/repeat.png"));//0是全部
		cycle.add(new Image(str+"icon_white/repeatone.png"));//1是单曲
		cycle.add(new Image(str+"icon_white/random.png"));//2是随机
		cycle.add(new Image(str+"icon_black/repeat.png"));//0是全部
		cycle.add(new Image(str+"icon_black/repeatone.png"));//1是单曲
		cycle.add(new Image(str+"icon_black/random.png"));//2是随机

		Image last_w=new Image(str+"icon_white/last.png");
		Image last_b=new Image(str+"icon_black/last.png");
		Image play_w=new Image(str+"icon_white/play.png");
		Image play_b=new Image(str+"icon_black/play.png");
		Image pause_w=new Image(str+"icon_white/pause.png");
		Image pause_b=new Image(str+"icon_black/pause.png");
		Image next_w=new Image(str+"icon_white/next.png");
		Image next_b=new Image(str+"icon_black/next.png");
		Image list_w=new Image(str+"icon_white/list.png");
		Image list_b=new Image(str+"icon_black/list.png");
		Image vol_w=new Image(str+"icon_white/vol.png");
		Image vol_b=new Image(str+"icon_black/vol.png");
		Image mute_w=new Image(str+"icon_white/mute.png");
		Image mute_b=new Image(str+"icon_black/mute.png");

		//set图标
		iv_set=new ImageView(set_w);
		iv_set.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_set.setImage(set_b);
				}
				if(newValue== false) {
					iv_set.setImage(set_w);
				}
			}
		});


		//循环方式
		iv_cycle=new ImageView(cycle.get(cycletype.get()));

		//cycle图片阴暗变化
		iv_cycle.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_cycle.setImage(cycle.get(cycletype.get()+3));
				}
				if(newValue== false) {
					iv_cycle.setImage(cycle.get(cycletype.get()));
				}
			}
		});

		//改变cycletype
		iv_cycle.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					cycletype.set((cycletype.get()+1)%3);
					iv_cycle.setImage(cycle.get(cycletype.get()+3));
				}
			}
		});

		//----------------------------------------------------------------------------------------------------------
		//上一首
		iv_last=new ImageView(last_w);
		//图片阴暗变化
		iv_last.hoverProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_last.setImage(last_b);
				}
				if(newValue == false) {
					iv_last.setImage(last_w);
				}
			}
		});

		//点击上一首，调整playindex
		iv_last.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY) && mp!=null)
//				playindex.set( (playindex.get()-1+medias.size())%medias.size() );
				playindex.set( (playindex.get()-1+files.size())%files.size() );
			}
		});

		//-----------------------------------------------------------------------------------------------------------
		//播放 与 暂停
		iv_play=new ImageView(play_w);

		//图片阴暗变化
		iv_play.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					if(isplaying.get()) {//playing
						iv_play.setImage(pause_b);
					}
					if(!isplaying.get()) {//pause
						iv_play.setImage(play_b);
					}
				}
				if(newValue == false) {
					if(isplaying.get()) {//playing
						iv_play.setImage(pause_w);
					}
					if(!isplaying.get()) {//pause
						iv_play.setImage(play_w);
					}
				}
			}
		});

		//播放
		iv_play.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY) && mp!=null) {
					if(mp!=null) {
						isplaying.set(!isplaying.get());
					}

				}
			}
		});

		isplaying.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue==true) {//isplaying
					iv_play.setImage(pause_w);
					if(mp.getStatus().equals(Status.PAUSED)) {
						mp.play();
					}else {
						myPlay();
					}
				}
				if(newValue==false) {
					iv_play.setImage(play_b);
					mp.pause();
				}
			}
		});
		//------------------------------------------------------------------------------------------------------------------
		//下一首
		iv_next=new ImageView(next_w);
		//图片阴暗变化
		iv_next.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_next.setImage(next_b);
				}
				if(newValue == false) {
					iv_next.setImage(next_w);
				}
			}
		});
		//点击下一首，改变playindex
		iv_next.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY) && mp!=null) {
					if(cycletype.get()==0 || cycletype.get()==1) {//all one
//						playindex.set( (playindex.get()+1)%medias.size() );
						playindex.set( (playindex.get()+1)%files.size() );
					}
					if(cycletype.get()==2) {//ran
//						playindex.set(ran.nextInt(medias.size()));
						playindex.set(ran.nextInt(files.size()));
					}
				}
			}
		});


		//---------------------------------------------------------------------------------------------------------------------
		//音乐列表
		iv_list=new ImageView(list_w);
		iv_list.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					iv_list.setImage(list_b);
				}
				if(newValue == false) {
					iv_list.setImage(list_w);
				}
			}
		});

		//---------------------------------------------------------------------------------------------------------------------
		//音量
		iv_vol=new ImageView(vol_w);

		//音量图片阴暗变化
		iv_vol.hoverProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if (newValue == true) {
					if (iv_vol.getImage().equals(vol_w)) {
						iv_vol.setImage(vol_b);
					} else if (iv_vol.getImage().equals(mute_w)) {
						iv_vol.setImage(mute_b);
					}
				}
				if (newValue == false) {
					if (iv_vol.getImage().equals(vol_b)) {
						iv_vol.setImage(vol_w);
					} else if (iv_vol.getImage().equals(mute_b)) {
						iv_vol.setImage(mute_w);
					}
				}
			}
		});
		//音量点击
		iv_vol.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY) && mp != null) {
					if(mp.isMute()== true) {//已经静音，点击播放
						mp.setMute(false);
						iv_vol.setImage(vol_b);
					}else {
						mp.setMute(true);
						iv_vol.setImage(mute_b);

					}
				}
			}
		});
		//---------------------------------------------------------------------------------------------------------------------
		//音量滑动条
		sl_vol=new Slider(0,1,0.1);
		sl_vol.setPrefWidth(100);

		//---------------------------------------------------------------------------------------------------------------------
		hbox_icon.getChildren().addAll(iv_set,iv_cycle, iv_last, iv_play, iv_next, iv_list,iv_vol,sl_vol);
		hbox_icon.getChildren().forEach(node -> {
			try {
				ImageView iv = (ImageView) node;
				iv.setPickOnBounds(true);
				iv.setFitHeight(iconheight);
				iv.setPreserveRatio(true);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("hbox_icon");
			}
		});

		vbox.getChildren().addAll(an,hbox_icon);

		anpane.getChildren().addAll(spectrum,label_name,label_time,vbox);



		//调整布局
		hbox_icon.setSpacing(20);

		vbox.setSpacing(20);

		vbox.setPadding(new Insets(20,20,20,20));

		spectrum.prefWidthProperty().bind(anpane.widthProperty());
//		AnchorPane.setLeftAnchor(spectrum, 0.0);
		AnchorPane.setBottomAnchor(spectrum, 0.0);

		AnchorPane.setLeftAnchor(label_name, 25.0);
		AnchorPane.setTopAnchor(label_name, 0.0);

		AnchorPane.setRightAnchor(label_time, 25.0);
		AnchorPane.setTopAnchor(label_time, 0.0);

		AnchorPane.setRightAnchor(vbox, 5.0);
		AnchorPane.setLeftAnchor(vbox, 5.0);
		AnchorPane.setTopAnchor(vbox, 5.0);
		AnchorPane.setBottomAnchor(vbox, 5.0);

//		spectrum.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
//		hbox_icon.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, null)));
//		vbox.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, null)));
//		anpane.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, null)));


	}





	public void myPlay(){

		media=new Media(files.get(playindex.get()).toURI().toASCIIString());

		mp.dispose();

//		mp=new MediaPlayer(medias.get(playindex.get()));
		mp=new MediaPlayer(media);

		mp.setOnReady(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mp.play();
				isplaying.set(true);
			}
		});

		isplaying.set(true);
		sb=new StringBuffer(files.get(playindex.get()).getName());
		label_name.setText(sb.substring(0, sb.length()-4));

		//矩形的长度绑定到an的宽*播放进度
		rec_progress.widthProperty().bind(playprogress.multiply(an.widthProperty()));

		//音量绑定到滑动条
		mp.volumeProperty().bind(sl_vol.valueProperty());

		//监听播放时间，调整播放进度progress
		mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
				// TODO Auto-generated method stub
				playprogress.set(newValue.toSeconds()/mp.getTotalDuration().toSeconds());

				int m1,s1,m2,s2;
				m1=(int)newValue.toMinutes();
				s1=(int)(newValue.toSeconds()%60);

				m2=(int)mp.getTotalDuration().toMinutes();
				s2=(int)(mp.getTotalDuration().toSeconds()%60);

				label_time.setText(m1+":"+s1+" / "+m2+":"+s2);
			}
		});

		mp.setAudioSpectrumListener(new AudioSpectrumListener() {

			@Override
			public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++) {
					st.getHeight().get(i).set((magnitudes[i]+60)*2.0f);
				}
			}
		});

		//播放结束，根据循环方式修改playindex
		mp.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(cycletype.get() == 0) {
//					playindex.set((playindex.get()+1)%medias.size());
					playindex.set((playindex.get()+1)%files.size());
				}else if(cycletype.get() == 1) {
					playindex.set(playindex.get());
					myPlay();
				}else {
//					playindex.set( (playindex.get()+ran.nextInt(medias.size())%medias.size()) );
					playindex.set( (playindex.get()+ran.nextInt(files.size())%files.size()) );
				}
			}
		});

	}

	public AnchorPane getBotView() {
		return anpane;
	}

	public SimpleIntegerProperty getPlayindex() {
		return playindex;
	}

	public ImageView getIv_list() {
		return iv_list;
	}

	public ImageView getIv_set() {
		return iv_set;
	}

}


