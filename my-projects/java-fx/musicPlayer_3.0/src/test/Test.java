///**
// * 
// */
//package test;
//
//import java.util.function.Consumer;
//
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.collections.ObservableMap;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import javafx.event.EventHandler;
//import javafx.scene.media.Media;
//import javafx.stage.Stage;
//import tools.MusicFileFromPath;
//
///**
// * @author Z H
// *
// */
//public class Test extends Application{
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		launch(args);
//		
//	}
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage.show();
//		
//		MyTask mt=new MyTask();
//		
//		Thread th=new Thread(mt);
//		
//		th.start();
//		
//		mt.progressProperty().addListener(new ChangeListener<Number>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//		});
//		
//		mt.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//			
//			@Override
//			public void handle(WorkerStateEvent event) {
//				// TODO Auto-generated method stub
//				mt.getValue().forEach(new Consumer<Media>() {
//
//					@Override
//					public void accept(Media t) {
//						// TODO Auto-generated method stub
//						ObservableMap<String, Object>map=t.getMetadata();
//						System.out.println(map.get("title"));
////						map.keySet().forEach(new Consumer<String>() {
////
////							@Override
////							public void accept(String t) {
////								// TODO Auto-generated method stub
////								System.out.println("key="+t+" value="+map.get(t));
////								System.out.println();
////							}
////						});
//					}
//				});
//			}
//		});
//	}
//
//}
//
//class MyTask extends Task<ObservableList<Media>>{
//	
//	public MyTask() {
//		
//	}
//	
//	ObservableList<Media> medias=FXCollections.observableArrayList();
//
//	Media media;
//	
//	int max=MusicFileFromPath.getMusicFiles().size();
//	
//	
//	int sum=0;
//	
//	
//	@Override
//	protected void updateProgress(long workDone, long max) {
//		// TODO Auto-generated method stub
//		super.updateProgress(workDone, max);
//	}
//
//	@Override
//	protected void updateProgress(double workDone, double max) {
//		// TODO Auto-generated method stub
//		super.updateProgress(workDone, max);
//	}
//
//	@Override
//	protected void updateMessage(String message) {
//		// TODO Auto-generated method stub
//		super.updateMessage(message);
//	}
//
//	@Override
//	protected void updateTitle(String title) {
//		// TODO Auto-generated method stub
//		super.updateTitle(title);
//	}
//
//	@Override
//	protected void updateValue(ObservableList<Media> value) {
//		// TODO Auto-generated method stub
//		super.updateValue(value);
//		
//	}
//
//	@Override
//	protected ObservableList<Media> call() throws Exception{
//		// TODO Auto-generated method stub
//		
//		System.out.println("call");
//		
//		System.out.println("max="+max);
//		
//		MusicFileFromPath.getMusicFiles().forEach(file->{
//			
//			media = new Media(file.toURI().toASCIIString());
//			
//			medias.add(media);
//			
//			sum++;
//			
//			this.updateProgress(sum, max);
//			
//		});
//		
//		return medias;
//		
//	}
//	
//}
