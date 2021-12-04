/**
 * 
 */
package tools;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;

/**
 * @author Z H
 *
 */
public class MusicFileFromMySQL {
	
	private static ObservableList<File> dirs=FXCollections.observableArrayList();
	
	private static ObservableList<Media> medias=FXCollections.observableArrayList();
	
	private static ObservableList<File> files=FXCollections.observableArrayList();
	
	//获取存放音乐的目录
	public static ObservableList<File> getDirsList() {

		if (dirs.size()==0) {
			
			String sql = "select * from tb_folder";

			ResultSet rs = null;

			rs = ConnectMySQL.executeQuery(sql);

			try {
				while (rs.next()) {
					System.out.println("getStirng:"+rs.getString("urlstring"));
					File dir = new File(rs.getString("urlstring"));
					
					if (dir.isDirectory()) {
						System.out.println("dir "+dir);
						dirs.add(dir);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConnectMySQL.close();
			return dirs;
			
		} else {
			
			return dirs;
		}
		
	}
	
	// 获取目录下的音乐媒体文件
	public static ObservableList<Media> getMusicMedias() {

		if (medias.size()==0) {
			
			getDirsList().forEach(dir -> {

				if (dir.exists()) {

					File[] files = dir.listFiles(new FilenameFilter() {

						@Override
						public boolean accept(File dir, String name) {
							// TODO Auto-generated method stub
							if (name.endsWith("mp3")) {
								return true;
							} else {
								return false;
							}
						}
					});
					for (int i = 0; i < files.length; i++) {
						Media media = new Media(files[i].toURI().toASCIIString());
						System.out.println("URI:"+files[i].toURI());
						medias.add(media);
					}
				}
			});
			return medias;
		} else {
			return medias;
		}

	}
	
	//获取目录下的音乐文件
	public static ObservableList<File> getMusicFiles() {

		if (files.size()==0) {
			
			getDirsList().forEach(dir -> {

				if (dir.exists()) {

					File[] mfiles = dir.listFiles(new FilenameFilter() {

						@Override
						public boolean accept(File dir, String name) {
							// TODO Auto-generated method stub
							if (name.endsWith("mp3")) {
								return true;
							} else {
								return false;
							}
						}
					});
					files.addAll(mfiles);
				}
			});
			return files;
		} else {
			return files;
		}
	}
	
	public static void addDir(File file) {
		
		dirs.add(file);
		
		File[] addfiles = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if (name.endsWith("mp3")) {
					return true;
				} else {
					return false;
				}
			}
		});
		for (int i = 0; i < addfiles.length; i++) {
			Media media = new Media(addfiles[i].toURI().toASCIIString());
			medias.add(media);
			files.add(addfiles[i]);
		}
		
//		MusicListView.getListview().refresh();
		
		String str="insert into tb_folder values (?)";
		
		PreparedStatement ps=null;
		
		try {
			ps=ConnectMySQL.executePreparedStatement(str);
			ps.setString(1, file.getAbsolutePath());
			ps.executeUpdate();
			ConnectMySQL.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("新目录写入数据库失败！");
		}
		
		
	}
	
	public static void deleteDir(File file) {

		dirs.remove(file);

		File[] subfiles = file.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if (name.endsWith("mp3")) {
					return true;
				} else {
					return false;
				}
			}
		});
		for (int i = 0; i < subfiles.length; i++) {
			if (files.contains(subfiles[i]) == true) {
				System.out.println("remove:"+subfiles[i]);
				int index=files.indexOf(subfiles[i]);
				medias.remove(index);
				files.remove(index);
			}
		}
//		MusicListView.getListview().refresh();

		String str = "delete from tb_folder where urlstring = ?";

		PreparedStatement ps = null;

		try {
			ps = ConnectMySQL.executePreparedStatement(str);
			ps.setString(1, file.getAbsolutePath());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("删除目录失败！");
		}
	}
	
	
	
}


