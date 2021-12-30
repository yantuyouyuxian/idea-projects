/**
 * 
 */
package fx.com;


import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Z H
 *
 */
public class Main2 extends Application {

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

		Button bu=new Button("����");
		Rectangle rec=new Rectangle(100,100,Color.ANTIQUEWHITE);
		rec.setX(-50);
		rec.setY(-50);//�������Ͻ�����
		
		Path path=new Path();
		MoveTo mt=new MoveTo(0,0);
		LineTo lt=new LineTo(100,0);
		QuadCurveTo qc=new QuadCurveTo(50, 0, 100, 100);
		qc.setAbsolute(false);
		HLineTo ht=new HLineTo(100);
		ht.setAbsolute(false);
		CubicCurveTo ct=new CubicCurveTo(50,-50, 100,50, 150,0);
		ct.setAbsolute(false);
		VLineTo vt=new VLineTo(100);
		vt.setAbsolute(false);
		ArcTo at=new ArcTo(100, 50, 0, 100, 100, true, true);
		at.setAbsolute(false);
		ClosePath cp=new ClosePath();
		path.getElements().addAll(mt,lt,qc,ht,ct,vt,at,cp);
		path.setStrokeWidth(2);
		path.setStroke(Color.BLUE);
		AnchorPane an1=new AnchorPane();
		an1.setStyle("-fx-background-color:#55555555");
		an1.getChildren().add(path);
		
		PathTransition pt=new PathTransition();
		pt.setDuration(Duration.seconds(5));
		pt.setNode(rec);
		pt.setPath(path);
		pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		
		
		AnchorPane root=new AnchorPane();
		root.getChildren().addAll(bu,rec,an1);
		
//		AnchorPane.setTopAnchor(bu, 600.0);
		
		AnchorPane.setTopAnchor(rec, 100.0);
		AnchorPane.setLeftAnchor(rec, 100.0);
		
		AnchorPane.setTopAnchor(an1, 100.0);
		AnchorPane.setLeftAnchor(an1, 100.0);
		

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();

		bu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				pt.play();
			}
		});
		
		
	}

}
