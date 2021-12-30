package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;

public class MusicFileFromPath {

	private static ObservableList<File> dirs=FXCollections.observableArrayList();

//	private static ObservableList<Media> medias=FXCollections.observableArrayList();

	private static ObservableList<File> files=FXCollections.observableArrayList();

	//获取存放音乐的目录
	public static ObservableList<File> getDirsList() throws IOException {

		if (dirs.size()==0) {
			String str=System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/";
			File pathtxt=new File(str+"path.txt");
			System.out.println(pathtxt);
			if(!pathtxt.exists()) {
				pathtxt.createNewFile();
			}
			String dir;
			BufferedReader br=new BufferedReader(new FileReader(pathtxt));

			try {
				while((dir=br.readLine())!=null) {

					File file=new File(dir);

					if(file.exists() && file.isDirectory()) {

						dirs.add(file);

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br.close();

			return dirs;

		} else {

			return dirs;
		}

	}

	// 获取目录下的音乐媒体文件
//	public static ObservableList<Media> getMusicMedias() throws IOException {
//
//		if (medias.size()==0) {
//
//			getDirsList().forEach(dir -> {
//
//				if (dir.exists()) {
//
//					File[] files = dir.listFiles(new FilenameFilter() {
//
//						@Override
//						public boolean accept(File dir, String name) {
//							// TODO Auto-generated method stub
//							if (name.endsWith("mp3")) {
//								return true;
//							} else {
//								return false;
//							}
//						}
//					});
//					for (int i = 0; i < files.length; i++) {
//						Media media = new Media(files[i].toURI().toASCIIString());
//						medias.add(media);
//					}
//				}
//			});
//			return medias;
//		} else {
//			return medias;
//		}
//
//	}

	//获取目录下的音乐文件
	public static ObservableList<File> getMusicFiles() throws IOException {

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
//			Media media = new Media(addfiles[i].toURI().toASCIIString());
//			medias.add(media);
			files.add(addfiles[i]);
		}

		try {
			refreshPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				int index=files.indexOf(subfiles[i]);
//				medias.remove(index);
				files.remove(index);
			}
		}

		try {
			refreshPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void refreshPath() throws IOException {

		String str=System.getProperty("user.dir")+"/java-fx/musicPlayer_4.0/";
		File pathtxt=new File(str+"path.txt");
		if(!pathtxt.exists()) {
			pathtxt.createNewFile();
		}

		BufferedWriter bw=new BufferedWriter(new FileWriter(pathtxt));

		dirs.forEach(t->{
				// TODO Auto-generated method stub
				try {

					String s=t.getAbsolutePath();

					bw.write(s+"\r\n");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		bw.close();

	}

}
