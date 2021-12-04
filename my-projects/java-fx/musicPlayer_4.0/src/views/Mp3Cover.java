package views;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import tools.MusicFileFromPath;

public class Mp3Cover {

	private SimpleIntegerProperty playindex=new SimpleIntegerProperty(0);

	private SimpleBooleanProperty isplaying=new SimpleBooleanProperty(false);

	private static SimpleFloatProperty rx=new SimpleFloatProperty(150);

	private static SimpleFloatProperty ry=new SimpleFloatProperty(155);

	private AnchorPane anpane;

	private ImageView iv_cover;

	private Circle circle;

	private Ellipse e1,e2;

	private Image nullcover;

	private RotateTransition rt;



	public Mp3Cover(){

		initial();

	}

	public void initial()  {

		e1=new Ellipse(150, 150, 150, 150);
		e1.setStroke(Color.RED);
		e1.setFill(Color.TRANSPARENT);
		e1.radiusXProperty().bind(rx);


		e2=new Ellipse(150, 150, 155, 155);
		e2.setFill(Color.TRANSPARENT);
		e2.setStroke(Color.BLUE);
		e2.radiusYProperty().bind(ry);

//		nullcover=new Image("file:"+System.getProperty("user.dir")+"/nullcoverimg/nullcover.jpg");
		nullcover=new Image("file:"+System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/nullcoverimg/nullcover.jpg");


		anpane=new AnchorPane();

		iv_cover=new ImageView();

		iv_cover.setImage(getImage(playindex.get()));

		iv_cover.setFitWidth(300);
		iv_cover.setFitHeight(300);

		circle=new Circle(150);
		circle.setCenterY(150);
		circle.setCenterX(150);
		iv_cover.setClip(circle);
//		iv_cover.setPreserveRatio(true);

		rt=new RotateTransition(Duration.seconds(30), iv_cover);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setInterpolator(Interpolator.LINEAR);
		rt.setCycleCount(RotateTransition.INDEFINITE);

		anpane.getChildren().addAll(e1,e2,iv_cover);

		playindex.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				iv_cover.setImage(getImage(newValue.intValue()));
				rt.stop();
				iv_cover.setRotate(0);
				rt.play();
			}
		});

		isplaying.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if(newValue == true) {
					rt.play();
				}
				if(newValue == false) {
					rt.pause();
				}
			}
		});

	}

	public Image getImage(int index)   {



		AbstractID3v2Frame frame = null;

		try {



			if(MusicFileFromPath.getMusicFiles().size()!=0) {

				File file=MusicFileFromPath.getMusicFiles().get(index);

				MP3File mp3file=new MP3File(file);

				if(mp3file.getID3v2Tag() !=null) {

					frame = (AbstractID3v2Frame) (new MP3File(file).getID3v2Tag().getFrame("APIC"));

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(frame != null && frame.getBody()!=null) {
			FrameBodyAPIC body=(FrameBodyAPIC)frame.getBody();
			byte[] imgData=body.getImageData();
			return new Image(new ByteArrayInputStream(imgData));
		}else {
			return nullcover;
		}


	}

	public SimpleIntegerProperty getPlayindex() {
		return playindex;
	}

	public AnchorPane getCoverView() {
		return anpane;
	}

	public SimpleBooleanProperty getIsplaying() {
		return isplaying;
	}

	public static SimpleFloatProperty getRx() {
		return rx;
	}

	public static SimpleFloatProperty getRy() {
		return ry;
	}





}
