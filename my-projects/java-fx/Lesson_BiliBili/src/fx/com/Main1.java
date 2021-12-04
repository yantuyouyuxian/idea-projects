package fx.com;

import java.util.function.Consumer;

import com.sun.scenario.effect.impl.prism.PrImage;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

public class Main1 extends Application{
	public static void main(String[] args) {
//		ConnectionDM cdm=new ConnectionDM();
//		
//		cdm.setRequest_number("7145813");
//		
//		cdm.setRequest_url("https://api.live.bilibili.com/ajax/msg");
//		
//		cdm.connection();
//		
//		String data=cdm.getDMData();//原始数据
//		
//		ObservableList<DMData> list=ConnectionDM.findData(data);//获取并包装
//		
//		list.forEach(new Consumer<DMData>() {
//
//			@Override
//			public void accept(DMData t) {
//				// TODO Auto-generated method stub
//				System.out.println("name:"+t.getNickname()+" text:"+t.getText()+" time:"+t.getTimeline());
//			}
//		});
		
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		ConnectionDM cdm=new ConnectionDM();
		cdm.setRequest_url("https://api.live.bilibili.com/ajax/msg");
		
		VBox root=new VBox();
		root.setStyle("-fx-background-color:white");
		
		Button danmu=new Button("获取弹幕");
		TextField text_number=new TextField();
		text_number.setPromptText("请输入B站直播房间号");
		Button close=new Button("断开连接");
		
		HBox hbox=new HBox(10);
		hbox.getChildren().addAll(danmu,text_number,close);
		hbox.setAlignment(Pos.CENTER);
		
		TableView<DMData> tableview=new TableView<DMData>();
		tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableview.setTableMenuButtonVisible(true);
		
		TableColumn<DMData, String> tc_name=new TableColumn<DMData, String>("昵称");
		tc_name.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<DMData, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<DMData, String> param) {
						// TODO Auto-generated method stub
						SimpleStringProperty ssp = new SimpleStringProperty(param.getValue().getNickname());
						return ssp;
					}
				});
		TableColumn<DMData, String> tc_text = new TableColumn<DMData, String>("内容");
		tc_text.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<DMData, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<DMData, String> param) {
						// TODO Auto-generated method stub
						SimpleStringProperty ssp = new SimpleStringProperty(param.getValue().getText());
						return ssp;
					}
				});
		TableColumn<DMData, String> tc_time = new TableColumn<DMData, String>("时间");
		tc_time.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<DMData, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<DMData, String> param) {
						// TODO Auto-generated method stub
						SimpleStringProperty ssp = new SimpleStringProperty(param.getValue().getTimeline());
						return ssp;
					}
				});
		
		tableview.getColumns().add(tc_name);
		tableview.getColumns().add(tc_text);
		tableview.getColumns().add(tc_time);
		
		VBox.setVgrow(tableview, Priority.ALWAYS);
		
		root.getChildren().addAll(hbox,tableview);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("bilibiliDM");
		primaryStage.setWidth(500);
		primaryStage.setHeight(600);
		primaryStage.show();
		
		DanMuService dms=new DanMuService(cdm);
		
		dms.valueProperty().addListener(new ChangeListener<ObservableList<DMData>>() {

			@Override
			public void changed(ObservableValue<? extends ObservableList<DMData>> observable,
					ObservableList<DMData> oldValue, ObservableList<DMData> newValue) {
				// TODO Auto-generated method stub
				if(newValue != null) {
					tableview.setItems(newValue);
					tableview.scrollTo(newValue.size()-1);
				}
			}
		});
		
		
		
		danmu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(text_number.getText().equals("") == false) {
					cdm.setRequest_number(text_number.getText());
					
					dms.setDelay(Duration.seconds(0));
					
					dms.setPeriod(Duration.seconds(1));
					
					dms.start();
					
					danmu.setDisable(true);
					
					text_number.setDisable(true);
					
				}
			}
		});
		
		close.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				cdm.disconnect();
				dms.cancel();
				dms.reset();
				danmu.setDisable(false);
				
				text_number.setDisable(false);
			}
		});
		
		
		
	}
}
