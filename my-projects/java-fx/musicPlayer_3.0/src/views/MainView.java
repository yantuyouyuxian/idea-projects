/**
 *
 */
package views;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Z H
 *
 */
public class MainView extends Application{


	//��ק����
	double x=0,y=0;

	private Stage primaryStage;

	private TopView tv;
	private HBox topview;

	private BottomView bv;
	private AnchorPane bottomview;

	private MusicListView mlv;
	private AnchorPane listview;

	private SetFolderStage sfs;
	private Stage folderstage;

	private SetView sv;
	private VBox setview;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

	public void initial() throws IOException {
		tv=new TopView(primaryStage);
		topview=tv.getTopView();//

		bv=new BottomView();
		bottomview = bv.getBotView();//

		mlv=new MusicListView();
		listview=mlv.getMusicListView();//

		sfs=new SetFolderStage();
		folderstage=sfs.getSetstage();//
		folderstage.initOwner(primaryStage);

		sv=new SetView();
		setview=sv.getSetView();//


		bv.getPlayindex().bindBidirectional(mlv.getPlayindex());

		bv.getIv_list().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					mlv.getIsshowing().set(!mlv.getIsshowing().get());
				}
			}
		});

		bv.getIv_set().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					sv.getIsshowing().set(!sv.getIsshowing().get());

				}
			}
		});

		sv.getIv_folder().setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					folderstage.show();
				}
			}
		});

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage=stage;

		initial();

		//Բ�Ǿ���
		Rectangle bgclip=new Rectangle();
		bgclip.setArcHeight(30);
		bgclip.setArcWidth(30);
		//����ͼƬ
		String str="file:"+System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/";
		ImageView bg=new ImageView(str+"img/bg.jpg");
		bg.setSmooth(true);
		bg.setClip(bgclip);

		//���ڵ�
		AnchorPane root=new AnchorPane();
		//����Բ��
		root.setBackground(new Background(new BackgroundFill(null,new CornerRadii(20), null)));
		root.setBorder(new Border(new BorderStroke(null,null,new CornerRadii(20),null)));


		//��Բ��ͼƬ�͸��ڵ�Ŀ��
		bg.fitWidthProperty().bind(root.widthProperty());
		bg.fitHeightProperty().bind(root.heightProperty());
		bgclip.widthProperty().bind(root.widthProperty());
		bgclip.heightProperty().bind(root.heightProperty());


		//��botview�͸��ڵ�Ŀ�
		bottomview.prefWidthProperty().bind(root.widthProperty());

		//���
		root.getChildren().addAll(bg,topview,bottomview,listview,setview);

		//top
		AnchorPane.setRightAnchor(topview, 5.0);

		//bottom
		AnchorPane.setBottomAnchor(bottomview, 0.0);
		AnchorPane.setLeftAnchor(bottomview, 0.0);
		AnchorPane.setRightAnchor(bottomview, 0.0);

		//listview
		AnchorPane.setRightAnchor(listview, 0.0);
		AnchorPane.setTopAnchor(listview, 60.0);

		//setview
		AnchorPane.setLeftAnchor(setview, 0.0);
		AnchorPane.setTopAnchor(setview, 100.0);

		Scene scene=new Scene(root);
		scene.setFill(Color.TRANSPARENT);

		primaryStage.setFullScreenExitHint("");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(str+"icon_white/music.png"));
		primaryStage.setScene(scene);
		primaryStage.setTitle("Music Player");
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setHeight(750);
		primaryStage.setWidth(1550);
		primaryStage.show();


		//����ͼ��ק�ƶ�
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(primaryStage.isFullScreen()==false) {
					x=event.getX();
					y=event.getY();
				}
			}
		});
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(primaryStage.isFullScreen()== false) {
					primaryStage.setX(event.getScreenX()-x);
					primaryStage.setY(event.getScreenY()-y);
				}
			}
		});


	}
}
