package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main2 extends Application{
	
	int index=0;
	String data="";
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ListView<String> listview=new ListView<String>();
		
		ListView<String> lv=new ListView<String>();
		
		ObservableList<String> obslist=listview.getItems();
		lv.setPrefWidth(300);
		lv.setPrefHeight(200);
		
		obslist.addAll("data A","data B","data C","data D","data E","data F");
	

		listview.setPrefWidth(300);
		listview.setPrefHeight(400);
		
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,listview,lv);
		AnchorPane.setLeftAnchor(listview, 100.0);
		AnchorPane.setTopAnchor(listview, 100.0);
		
		AnchorPane.setLeftAnchor(lv, 500.0);
		AnchorPane.setTopAnchor(lv, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		listview.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				index=newValue.intValue();
			}
		});
		
		listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				data=newValue;
			}
		});
		
		
		
		listview.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			int position=0;
			String positionstr="";
			@Override
			public ListCell<String> call(ListView<String> param) {
				
				
				
//				System.out.println("listview setcellfactory "+param);
				Label label=new Label();
				label.setPrefHeight(20);
				label.setFont(new Font(15));
				
				// TODO Auto-generated method stub
				ListCell<String> cell=new ListCell<String>() {
					
					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
//						System.out.println("updateitem "+item+" "+empty);
						if(empty == false && item!=null) {
							label.setText(item);
							this.setGraphic(label);
							this.setOpacity(1);
						}else {
							this.setOpacity(0);
						}
						
					}
					
				};
				
				cell.setOnDragDetected(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Dragboard db=cell.startDragAndDrop(TransferMode.MOVE);
						
						ClipboardContent content=new ClipboardContent();
						content.putString(data);
						
						WritableImage wi=new WritableImage((int)cell.getWidth(), (int)cell.getHeight());
						cell.snapshot(new SnapshotParameters(), wi);
						db.setDragView(wi);
						
						db.setContent(content);
					}
				});
				
				cell.setOnDragEntered(new EventHandler<DragEvent>() {

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						position=param.getItems().indexOf(label.getText());
						positionstr=label.getText();
						param.getFocusModel().focus(position);
//						System.out.println(label.getText()+" "+position);
						
					}
				});
				
				cell.setOnDragOver(new EventHandler<DragEvent>() {

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						event.acceptTransferModes(TransferMode.MOVE);
					}
				});
				
				cell.setOnDragDropped(new EventHandler<DragEvent>() {

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						if(position==-1) {
							position=param.getItems().size()-1;
						}
//						String value=data;
						String value=event.getDragboard().getString();
						param.getItems().remove(index);
						param.getItems().add(position,value);
						param.getSelectionModel().select(position);
					}
				});
				
				return cell;
			}
		});
		
		lv.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				event.acceptTransferModes(TransferMode.MOVE);
			}
		});
		
		lv.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// TODO Auto-generated method stub
				lv.getItems().add(event.getDragboard().getString());
			}
		});
		
		
		
	}

}
