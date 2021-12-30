package fx.com;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main1 extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ListView<String> listview=new ListView<String>();
		
		ObservableList<String> obslist=listview.getItems();
		
		obslist.addAll("data A","data B","data C","data D","data E","data F","data G","data B","data C","data D","data E","data F","data G");
	

		listview.setPrefWidth(300);
		listview.setPrefHeight(200);
		
		
		Button bu=new Button("button");
		
		AnchorPane an=new AnchorPane();
		an.getChildren().addAll(bu,listview);
		AnchorPane.setLeftAnchor(listview, 100.0);
		AnchorPane.setTopAnchor(listview, 100.0);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		
		listview.setOnScroll(new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				// TODO Auto-generated method stub
//				System.out.println(event.getDeltaY());
			}
		});
		
		
		listview.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			int position=0;
			@Override
			public ListCell<String> call(ListView<String> param) {
				Label label=new Label();
				label.setPrefHeight(20);
				label.setFont(new Font(15));
				label.setStyle("-fx-background-color:yellow");
				
				// TODO Auto-generated method stub
				ListCell<String> cell=new ListCell<String>() {
					
					@Override
					protected void updateItem(String item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(empty == false && item!=null) {
							label.setText(item);
							
							this.setGraphic(label);
						}
					}
					
				};
				
				cell.hoverProperty().addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						// TODO Auto-generated method stub
						if(newValue == true && label.getText().equals("")==false) {
							
							position=param.getItems().indexOf(label.getText());
							param.getFocusModel().focus(position);
							System.out.println(label.getText()+" "+position);
							label.setPrefHeight(25);
							label.setFont(new Font(20));
						}else {
							label.setPrefHeight(20);
							label.setFont(new Font(15));
						}
					}
				});
				
				return cell;
			}
		});
		
	}

}
