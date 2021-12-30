/**
 * 
 */
package fx.com;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main1 extends Application {

	private ImageView lb;
	private ImageView rb;
	
	double index0_x=0;
	double index1_x=0;
	double index2_x=0;
	
	double img_y=0;
	
	double img_z=50;
	
	private ArrayList<ImageView> list;
	
	private Duration time=Duration.seconds(0.5);
	
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

		Pane pane=getView(700, 400);
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(pane);

		AnchorPane.setTopAnchor(pane, 200.0);
		AnchorPane.setLeftAnchor(pane, 200.0);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		lb.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				r_to_l(list);
			}
		});
		rb.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				l_to_r(list);
			}
		});
	
	}
	
	public Pane getView(int w,int h) {
		
		lb=new ImageView("img/icon.png");
		lb.setFitWidth(50);
		
		rb=new ImageView("img/icon.png");
		rb.setFitWidth(50);
		
		HBox hbox=new HBox(w-(lb.prefWidth(-1)*2));
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(lb,rb);
		
		
		ImageView iv1=new ImageView("img/1.jpeg");
		iv1.setFitWidth(400);
		iv1.setPreserveRatio(true);
		ImageView iv2=new ImageView("img/2.jpg");
		iv2.setFitWidth(400);
		iv2.setPreserveRatio(true);
		ImageView iv3=new ImageView("img/3.jpg");
		iv3.setFitWidth(400);
		iv3.setPreserveRatio(true);
		
		index0_x=0;
		index1_x=w/2-200;
		index2_x=w-400;
		
		iv1.setTranslateX(index0_x);
		iv2.setTranslateX(index1_x);
		iv3.setTranslateX(index2_x);
		
		img_y=h/2-iv1.prefHeight(-1)/2;
		
		iv1.setTranslateY(img_y);
		iv2.setTranslateY(img_y);
		iv3.setTranslateY(img_y);
		
		iv1.setTranslateZ(img_z);
		iv2.setTranslateZ(0);
		iv3.setTranslateZ(img_z);
		
		list=new ArrayList<ImageView>();
		list.add(iv1);
		list.add(iv2);
		list.add(iv3);
	
		AnchorPane ap=new AnchorPane();
		ap.getChildren().addAll(iv1,iv2,iv3);
		
		SubScene subscene=new SubScene(ap, w, h, true, SceneAntialiasing.BALANCED);
		
		PerspectiveCamera canmer=new PerspectiveCamera();
		subscene.setCamera(canmer);
		
		
		StackPane pane=new StackPane();
		pane.setStyle("-fx-background-color:#ffb6c1");
		
		pane.getChildren().addAll(subscene,hbox);
		
		return pane;
	}
	
	public void r_to_l(ArrayList<ImageView> list) {
		
		ImageView iv0=list.get(0);
		ImageView iv1=list.get(1);
		ImageView iv2=list.get(2);
		l_to_ra(iv0);
		m_to_la(iv1);
		r_to_ma(iv2);
		list.clear();
		
		list.add(iv1);
		list.add(iv2);
		list.add(iv0);
		
		
	}
	public void l_to_ra(ImageView iv) {
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index0_x);
		tt.setFromZ(img_z);
		
		tt.setToX(index2_x);
		tt.setToZ(img_z);
		tt.play();
		
	}
	public void r_to_ma(ImageView iv) {
		// TODO Auto-generated method stub
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index2_x);
		tt.setFromZ(img_z);
		
		tt.setToX(index1_x);
		tt.setToZ(0);
		tt.play();
	}

	public void m_to_la(ImageView iv) {
		// TODO Auto-generated method stub
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index1_x);
		tt.setFromZ(0);
		
		tt.setToX(index0_x);
		tt.setToZ(img_z);
		FadeTransition ft1=new FadeTransition(Duration.seconds(0.25));
		ft1.setFromValue(1);
		ft1.setToValue(0.6);
		FadeTransition ft2=new FadeTransition(Duration.seconds(0.25));
		ft2.setFromValue(0.6);
		ft2.setToValue(1);
		
		SequentialTransition st=new SequentialTransition();
		st.getChildren().addAll(ft1,ft2);
		
		ParallelTransition pt=new ParallelTransition();
		pt.setNode(iv);
		pt.getChildren().addAll(tt,st);
		
		pt.play();
	}

	public void l_to_r(ArrayList<ImageView> list) {
		
		ImageView iv0=list.get(0);
		ImageView iv1=list.get(1);
		ImageView iv2=list.get(2);
		l_to_ma(iv0);
		m_to_ra(iv1);
		r_to_la(iv2);
		list.clear();
		
		list.add(iv2);
		list.add(iv0);
		list.add(iv1);
	}

	public void l_to_ma(ImageView iv) {
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index0_x);
		tt.setFromZ(img_z);
		
		tt.setToX(index1_x);
		tt.setToZ(0);
		tt.play();
		
	}
	
	public void m_to_ra(ImageView iv) {
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index1_x);
		tt.setFromZ(0);
		
		tt.setToX(index2_x);
		tt.setToZ(img_z);
		
		FadeTransition ft1=new FadeTransition(Duration.seconds(0.25));
		ft1.setFromValue(1);
		ft1.setToValue(0.6);
		FadeTransition ft2=new FadeTransition(Duration.seconds(0.25));
		ft2.setFromValue(0.6);
		ft2.setToValue(1);
		
		SequentialTransition st=new SequentialTransition();
		st.getChildren().addAll(ft1,ft2);
		
		ParallelTransition pt=new ParallelTransition();
		pt.setNode(iv);
		pt.getChildren().addAll(tt,st);
		
		pt.play();
		
	}
	
	public void r_to_la(ImageView iv) {
		
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(time);
		tt.setNode(iv);
		
		tt.setFromX(index2_x);
		tt.setFromZ(img_z);
		
		tt.setToX(index0_x);
		tt.setToZ(img_z);
		
		tt.play();
		
	}
	
}
