/**
 *
 */
package fx.com;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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

	ArrayList<ParallelTransition> list=new ArrayList<>();
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

		File file=new File(System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/res/bgm.mp3");
		Media media=new Media(file.toURI().toASCIIString());
		MediaPlayer mp=new MediaPlayer(media);

		ImageView bg=new ImageView("file:/"+System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/res/bg.jpg");

		AnchorPane root = new AnchorPane();


		StackPane sp=new StackPane();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(800);
		primaryStage.setWidth(1600);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.show();

		Node flowerview=getFlowerView(50, (int)scene.getWidth(), (int)scene.getHeight(), 1000);


		sp.getChildren().addAll(flowerview);

		root.getChildren().addAll(bg,sp);

		KeyCombination key=new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN);
		scene.getAccelerators().put(key, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				list.forEach(new Consumer<ParallelTransition>() {

					@Override
					public void accept(ParallelTransition t) {
						// TODO Auto-generated method stub
						t.play();
					}
				});
				mp.setVolume(0.1);
				mp.play();
			}
		});

	}

	public Node getFlowerView(int number,int w,int h,int z) {
		Random ran=new Random();

		ArrayList<ImageView> img_list=new ArrayList<>();

		int lx;
		int ly;
		int lz;

		for(int i=0;i<number;i++) {
			String str=System.getProperty("user.dir");
			ImageView iv=new ImageView("file:"+str+"/res/redflower.png");
			iv.setPreserveRatio(true);
			iv.setFitWidth(50);

			if(ran.nextBoolean()==true) {
				lx=ran.nextInt(w)+300;
			}else {
				lx=ran.nextInt(w)-300;
			}
//			lx=ran.nextInt(w);
			ly=ran.nextInt(20);
			lz=ran.nextInt(z);

			iv.setTranslateX(lx);
			iv.setTranslateY(ly);
			iv.setTranslateZ(lz);
			iv.setOpacity(0);

			img_list.add(iv);
		}


		AnchorPane ap=new AnchorPane();
		ap.getChildren().addAll(img_list);

		SubScene subscene=new SubScene(ap, w, h,true,SceneAntialiasing.BALANCED);
//		subscene.setFill(Color.ANTIQUEWHITE);
		PerspectiveCamera camera=new PerspectiveCamera();
		subscene.setCamera(camera);

		img_list.forEach(new Consumer<ImageView>() {

			@Override
			public void accept(ImageView t) {
				// TODO Auto-generated method stub

				double time=ran.nextDouble()*10+10;

				TranslateTransition tt=new TranslateTransition(Duration.seconds(time));

				tt.setFromX(t.getTranslateX());
				tt.setFromY(t.getTranslateY());
				tt.setByX(400);
				tt.setByY(1300);

				FadeTransition ft1=new FadeTransition(Duration.seconds(time/2));
				ft1.setFromValue(0);
				ft1.setToValue(1);
				FadeTransition ft2=new FadeTransition(Duration.seconds(time/2));
				ft2.setFromValue(1);
				ft2.setToValue(0);

				SequentialTransition st=new SequentialTransition();
				st.getChildren().addAll(ft1,ft2);

				RotateTransition rt=new RotateTransition(Duration.seconds(time));
				rt.setFromAngle(0);
				rt.setToAngle(360);

				ParallelTransition pt=new ParallelTransition();
				pt.getChildren().addAll(tt,st,rt);
				pt.setNode(t);
				pt.setCycleCount(TranslateTransition.INDEFINITE);
				pt.setInterpolator(Interpolator.LINEAR);

				list.add(pt);

			}
		});


		return subscene;
	}

}
