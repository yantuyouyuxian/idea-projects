/**
 * 
 */
package fx.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
		
		AnchorPane an=new AnchorPane();
		
		VBox vbox=new VBox(10);
		
		Button b1 =new Button("��ѡ�ļ�����");
		Button b2 =new Button("��ѡ�ļ�����");
		Button b3 =new Button("���ı�");
		Button b4 =new Button("�����ı�");
		
		Button b5 =new Button("ѡ���ļ���");
		TextArea ta=new TextArea();
		ta.setWrapText(true);
		
		vbox.getChildren().addAll(b1,b2,b3,b4,b5,ta);
		
		an.getChildren().add(vbox);
		
		Scene scene=new Scene(an);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFx");
		primaryStage.setHeight(600);
		primaryStage.setWidth(1000);
		primaryStage.show();
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc =new FileChooser();
				Stage stage=new Stage();
//				stage.setTitle("stage");//wu yong
				fc.setTitle("��ѡ�ļ�");
				fc.setInitialDirectory(new File("E:"+File.separator+"Users"+File.separator+"Z H"));
				
				fc.getExtensionFilters().addAll(
						new ExtensionFilter("ͼƬ����","*.jpg","*.png"),
						new ExtensionFilter("�ı�����","*.txt"),
						new ExtensionFilter("��������","*.*"));
				
				File file=fc.showOpenDialog(stage);
				
				if(file==null) {
					return ;
				}
				
				System.out.println(file.getAbsolutePath());
				
			}
		});
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc =new FileChooser();
				Stage stage=new Stage();
//				stage.setTitle("stage");//wu yong
				fc.setTitle("��ѡ�ļ�");
				fc.setInitialDirectory(new File("E:"+File.separator+"Users"+File.separator+"Z H"));
				
				fc.getExtensionFilters().addAll(
						new ExtensionFilter("ͼƬ����","*.jpg","*.png"),
						new ExtensionFilter("�ı�����","*.txt"),
						new ExtensionFilter("��������","*.*"));
				
				List<File> list=fc.showOpenMultipleDialog(stage);
				
				if(list==null) {
					return ;
				}
				
				list.forEach(new Consumer<File>() {

					@Override
					public void accept(File t) {
						// TODO Auto-generated method stub
						System.out.println(t.getAbsolutePath());
					}
				});
			}
		});
		
		b3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc =new FileChooser();
				Stage stage=new Stage();
//				stage.setTitle("stage");//wu yong
				fc.setTitle("��ѡ�ļ�");
				fc.setInitialDirectory(new File("E:"+File.separator+"Users"+File.separator+"Z H"));
				
				fc.getExtensionFilters().addAll(
						new ExtensionFilter("ͼƬ����","*.jpg","*.png"),
						new ExtensionFilter("�ı�����","*.txt"),
						new ExtensionFilter("��������","*.*"));
				
				File file=fc.showOpenDialog(stage);
				
				if(file==null) {
					return ;
				}
				
				System.out.println(file.getAbsolutePath());
				
				try {
					FileInputStream fis=new FileInputStream(file);
					
					InputStreamReader read=new InputStreamReader(fis, "UTF-8");
					
//					FileReader fr=new FileReader(file);
					
					BufferedReader br=new BufferedReader(read);
					String str=null;
					while((str=br.readLine())!=null) {
						ta.appendText(str+"\n");
					}
					br.close();
//					fr.close();
					read.close();
					fis.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		b4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc =new FileChooser();
				Stage stage=new Stage();
//				stage.setTitle("stage");//wu yong
				fc.setTitle("�����ļ�");
				fc.setInitialFileName("���ļ���");
				fc.setInitialDirectory(new File("E:"+File.separator+"Users"+File.separator+"Z H"));
				
				fc.getExtensionFilters().addAll(new ExtensionFilter("�ı�����","*.txt"));
				
				File file=fc.showSaveDialog(stage);
				
				if(file==null) {
					return ;
				}
				
				System.out.println(file.getAbsolutePath());
				
				try {
					FileOutputStream fos=new FileOutputStream(file);
					
					OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
					osw.write(ta.getText());
					osw.close();
					fos.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		
		b5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				DirectoryChooser dc=new DirectoryChooser();
				Stage stage =new Stage();
				dc.setTitle("�ļ���ѡ����");
				dc.setInitialDirectory(new File("E:"+File.separator+"Users"+File.separator+"Z H"));
				
				File file=dc.showDialog(stage);
				if(file!=null) {
					System.out.println(file.getAbsolutePath());
					File[] files=file.listFiles();
					for(File f:files) {
						System.out.println(f.getAbsolutePath());
					}
				}
			}
		});
	}

}
