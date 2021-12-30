package views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import tools.MusicFileFromPath;

public class LyricView {
	private SubScene subscene;
	
	private AnchorPane an;
	
	private VBox vbox;
	
	private LinkedHashMap<Integer, String> map;
	
	private ArrayList<Label> array;
	
	
	private TranslateTransition tt;
	
	private SimpleIntegerProperty playindex=new SimpleIntegerProperty(0);
	
	private static SimpleIntegerProperty playtime=new SimpleIntegerProperty(0);

	private int width=500;
	
	private int height=400;
	
	private int labh=70;
	
	private int translatey=height/2-labh/2;
	
	private int gap=10;
	
	public LyricView() {
		an=new AnchorPane();
		an.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
//		an.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		an.setPrefHeight(height);
		an.setPrefWidth(width);
		
		subscene=new SubScene(an, width, height,true,SceneAntialiasing.BALANCED);
		PerspectiveCamera camera=new PerspectiveCamera();
		subscene.setCamera(camera);
		subscene.setFill(Color.TRANSPARENT);
		
		vbox=new VBox(gap);
		vbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		vbox.setPrefWidth(width);
		vbox.setAlignment(Pos.CENTER);
//		vbox.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
		tt=new TranslateTransition(Duration.seconds(0.5),vbox);
		
		an.getChildren().add(vbox);
		
		initial();
		
		playindex.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				vbox.getChildren().clear();
				
				initial();
				
			}
		});
		
	}
	
	public void initial() {
		
		vbox.setTranslateY(translatey);
		
		map=getLrcMap();
		
		array=new ArrayList<>();
		
		map.forEach(new BiConsumer<Integer, String>() {

			@Override
			public void accept(Integer t, String u) {
				// TODO Auto-generated method stub
				
				Label lab=new Label(u);
				lab.setWrapText(true);
				lab.setTranslateZ(100);
				lab.setTextAlignment(TextAlignment.CENTER);
				lab.setId(String.valueOf(t));
				lab.setFont(Font.font(20));
				lab.setTextFill(Color.WHITE);
				lab.setPrefHeight(labh);
				
				array.add(lab);
				vbox.getChildren().add(lab);
			}
		});
		
		
		
		playtime.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				if(map.containsKey(newValue.intValue())) {
					
					FilteredList<Node> flist=vbox.getChildren().filtered(new Predicate<Node>() {
						
						@Override
						public boolean test(Node t) {
							// TODO Auto-generated method stub
							if(t.getId().equals(String.valueOf(newValue.intValue()))) {
								return true;
							}
							else {
								return false;
							}
						}
					});
					
					Label lab=(Label)flist.get(0);
					lab.setTranslateZ(0);
					lab.setTextFill(Color.DEEPSKYBLUE);
					
					int index=array.indexOf(lab);
					if(index-1>=0) {
						array.get(index-1).setTextFill(Color.WHITE);
						array.get(index-1).setTranslateZ(100);
					}
				
					tt.setFromY(vbox.getTranslateY());
					tt.setToY(translatey-(labh+gap)*index);
					tt.play();
				}
			}
		});
		
	}
	
	public SubScene getLyricView() {
		
		return subscene;
	}
	
	public SimpleIntegerProperty getPlayindex() {
		return playindex;
	}

	public static SimpleIntegerProperty getPlaytime() {
		return playtime;
	}

	public LinkedHashMap<Integer,String> getLrcMap(){
		
		
		LinkedHashMap<Integer,String> map=new LinkedHashMap<>();
		
		FileReader fr=null;
		
		BufferedReader br=null;
		
		if(MusicFileFromPath.getMusicFiles().size()!=0) {
			
			File mp3file=MusicFileFromPath.getMusicFiles().get(playindex.get());
			
			File lrcfile=new File(mp3file.getPath().replace(".mp3", ".lrc"));
			
			
			if(lrcfile.exists() &&lrcfile.isFile()) {
				
				try {
					
//					InputStreamReader isr=new InputStreamReader(new FileInputStream(lrcfile), "UTF-8");
					
					fr=new FileReader(lrcfile);
					
					br=new BufferedReader(fr);
					
					String regex="\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,2})\\]";
					
					Pattern pattern=Pattern.compile(regex);
					
					String linestr=null;
					
					try {
						while((linestr=br.readLine())!=null) {
							
							Matcher matcher=pattern.matcher(linestr);
							
							while(matcher.find()) {
								String min=matcher.group(1);
								
								String sec=matcher.group(2);
								
//								String mill=matcher.group(3);
								
								int m=Integer.parseInt(min);
								int s=Integer.parseInt(sec);
//								int ms=Integer.parseInt(mill);
								
//								Integer time=m*60*1000+s*1000+ms*10;
								Integer time=m*60+s;
								
								String text=linestr.substring(matcher.end());
								
								if(text.trim().length()>0) {
									
									map.put(time, text);
									
								}
							}	
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				map.keySet().forEach(new Consumer<Integer>() {
//
//					@Override
//					public void accept(Integer t) {
//						// TODO Auto-generated method stub
//						System.out.println(t+"--"+map.get(t));
//					}
//				});
				
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				
				map.put(0, "Î´ÕÒµ½¸è´ÊÎÄ¼þ");
				
			}	
		}
		return map;
	}
}
