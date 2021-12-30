/**
 * 
 */
package fx.com;

import java.util.Comparator;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * @author Z H
 *
 */
public class Main1 extends Application{

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
	
		DataPro d1=new DataPro("A", "20");
		DataPro d2=new DataPro("B", "21");
		DataPro d3=new DataPro("C", "22");
		DataPro d4=new DataPro("D", "23");
	
		ObservableList<DataPro> list=FXCollections.observableArrayList(new Callback<DataPro, Observable[]>(){

			@Override
			public Observable[] call(DataPro param) {
				// TODO Auto-generated method stub
				SimpleStringProperty [] array=new SimpleStringProperty[] {param.getNameProperty(),param.getAgeProperty()};
				return array;
			}
			
		});
		
		ListView<DataPro> listview=new ListView<DataPro>(list);
		
		ObservableList<DataPro> obslist=listview.getItems();//返回上面设置的list
		
		obslist.addAll(d1,d2,d3,d4);
	

		listview.setPrefWidth(500);
		listview.setPrefHeight(300);
		listview.setEditable(true);
		
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
		
		listview.setEditable(true);
		
		listview.setCellFactory(new Callback<ListView<DataPro>, ListCell<DataPro>>() {
			int index=0;
			DataPro temp=null;
			ListCell<DataPro> cell;
			
			@Override
			public ListCell<DataPro> call(ListView<DataPro> param) {
				
				param.setOnEditStart(new EventHandler<ListView.EditEvent<DataPro>>() {
					
					@Override
					public void handle(EditEvent<DataPro> event) {
						// TODO Auto-generated method stub
						index=event.getIndex();
						temp=param.getItems().get(index);
					}
				});
				
				// TODO Auto-generated method stub
				ListCell<DataPro> listcell=new ListCell<DataPro>() {

					
					@Override
					public void updateSelected(boolean selected) {
						// TODO Auto-generated method stub
						System.out.println("updateSelected");
						super.updateSelected(selected);
					}

					@Override
					protected boolean isItemChanged(DataPro oldItem, DataPro newItem) {
						// TODO Auto-generated method stub
						System.out.println("isItemChanged");
						return super.isItemChanged(oldItem, newItem);
					}

//					@Override
//					public void commitEdit(DataPro newValue) {
//						// TODO Auto-generated method stub
//						super.commitEdit(newValue);
//						
//						
//					}

					@Override
					public void cancelEdit() {
						// TODO Auto-generated method stub
						super.cancelEdit();
						HBox hbox=new HBox(10);
						hbox.setAlignment(Pos.CENTER_LEFT);
						ImageView iv=new ImageView("image/tou.jpg");
						iv.setPreserveRatio(true);
						iv.setFitHeight(30);
						Button button=new Button(temp.getName()+" button");
						Label name=new Label(temp.getName());
						Label age=new Label(temp.getAge());
						hbox.getChildren().addAll(iv,button,name,age);
						this.setGraphic(hbox);
					}

					@Override
					public void startEdit() {
						// TODO Auto-generated method stub
						cell=this;
						super.startEdit();
						HBox hbox=new HBox(10);
						hbox.setAlignment(Pos.CENTER_LEFT);
						ImageView iv=new ImageView("image/tou.jpg");
						iv.setPreserveRatio(true);
						iv.setFitHeight(30);
						Button button=new Button(temp.getName()+" button");
						
						TextField name=new TextField(temp.getName());
						name.setPrefWidth(50.0);
						TextField age=new TextField(temp.getAge());	
						age.setPrefWidth(50.0);
						hbox.getChildren().addAll(iv,button,name,age);
						this.setGraphic(hbox);
						
						name.setOnAction(new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								if(name.getText().equals("")) {
									cell.commitEdit(temp);
								}else {
									temp.setName(name.getText());
									temp.setAge(age.getText());
									cell.commitEdit(temp);
								}
							}
						});

						age.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								// TODO Auto-generated method stub
								if (age.getText().equals("")) {
									cell.commitEdit(temp);
								} else {
									temp.setName(name.getText());
									temp.setAge(age.getText());
									cell.commitEdit(temp);
								}
							}
						});
						
					}

					@Override
					protected void updateItem(DataPro item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						
						if(empty==false) {
							HBox hbox=new HBox(10);
							hbox.setAlignment(Pos.CENTER_LEFT);
							ImageView iv=new ImageView("image/tou.jpg");
							iv.setPreserveRatio(true);
							iv.setFitHeight(30);
							Button button=new Button(item.getName()+" button");
							Label name=new Label(item.getName());
							Label age=new Label(item.getAge());
							hbox.getChildren().addAll(iv,button,name,age);
							this.setGraphic(hbox);
							button.setOnAction(new EventHandler<ActionEvent>() {
								
								@Override
								public void handle(ActionEvent event) {
									// TODO Auto-generated method stub
									System.out.println(item.getName()+" "+item.getAge());
								}
							});
						}
						
					}
					
				};
				return listcell;
			}
		});

		
		
	
		
		
		
	}
}

class DataPro{
	
	private SimpleStringProperty name=new SimpleStringProperty();
	
	private SimpleStringProperty age=new SimpleStringProperty();
	
	public DataPro(String name,String age) {
		this.name.set(name);
		this.age.set(age);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getAge() {
		return age.get();
	}
	
	public void setAge(String age) {
		this.age.set(age);
	}
	
	public SimpleStringProperty getNameProperty() {
		return this.name;
	}
	
	public SimpleStringProperty getAgeProperty() {
		return this.age;
	}
	
	
}
