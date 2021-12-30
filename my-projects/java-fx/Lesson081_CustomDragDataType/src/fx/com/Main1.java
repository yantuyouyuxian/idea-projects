/**
 * 
 */
package fx.com;

import java.io.Serializable;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

	public DataFormat person_format=new DataFormat("data/person");
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
		
		Person person=new Person("123123", "18", "file:E:\\Users\\Z H\\Desktop\\images/tou.jpg");
		
		Button bu=new Button(person.getNaem());
		
		VBox view=getDataPane();
		((TextField)view.getChildren().get(1)).setText(person.getNaem());
		((TextField)view.getChildren().get(2)).setText(person.getAge());
		((ImageView)view.getChildren().get(3)).setImage(new Image(person.getPhoto()));
	
		
		VBox datapane=getDataPane();
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,datapane);
		AnchorPane.setLeftAnchor(datapane, 300.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		bu.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Dragboard db=bu.startDragAndDrop(TransferMode.COPY_OR_MOVE);
				
				ClipboardContent content=new ClipboardContent();
				
				content.put(person_format, person);
				db.setContent(content);
				
				an.getChildren().add(view);
				
				WritableImage wi=new WritableImage((int)view.getPrefWidth(), (int)view.getPrefHeight());
				view.snapshot(new SnapshotParameters(), wi);
				an.getChildren().remove(2);
				db.setDragView(wi);
			}
		});
		
		datapane.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
		});
		
		datapane.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				Dragboard db=event.getDragboard();
				Object obj=db.getContent(DataFormat.lookupMimeType("data/person"));
//				db.getContent(person_format);
				
				Person p=(Person)obj;
				
				((TextField)datapane.getChildren().get(1)).setText(p.getNaem());
				((TextField)datapane.getChildren().get(2)).setText(p.getAge());
				((ImageView)datapane.getChildren().get(3)).setImage(new Image(p.getPhoto()));
			}
		});
		
	}
	
	public VBox getDataPane() {
		
		VBox vbox=new VBox(10);
		vbox.setStyle("-fx-border-color:red");
		vbox.setPrefWidth(300);
		vbox.setPrefHeight(500);
		
		Button bu=new Button("个人信息");
//		bu.setMaxWidth(vbox.getPrefWidth());
		bu.prefWidthProperty().bind(vbox.prefWidthProperty());
		
		TextField t1=new TextField();
		t1.setAlignment(Pos.CENTER);
		TextField t2=new TextField();
		t2.setAlignment(Pos.CENTER);
		ImageView iv=new ImageView();
		
		iv.setPreserveRatio(true);
		iv.setFitWidth(vbox.getPrefWidth());
		
		vbox.getChildren().addAll(bu,t1,t2,iv);
		
		return vbox;
	}

}

class Person implements Serializable{
	private String naem;
	

	private String age;
	private String photo;
	
	public Person(String name,String age,String photo) {
		this.naem=name;
		this.age=age;
		this.photo=photo;
	}
	
	public String getNaem() {
		return naem;
	}

	public void setNaem(String naem) {
		this.naem = naem;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
