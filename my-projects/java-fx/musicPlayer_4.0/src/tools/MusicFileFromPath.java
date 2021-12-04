package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;

public class MusicFileFromPath {

    private static ObservableList<File> dirs = FXCollections.observableArrayList();

    private static ObservableList<Media> medias = FXCollections.observableArrayList();

    private static ObservableList<File> files = FXCollections.observableArrayList();

    private static String abpath = System.getProperty("user.dir") + "/";

    static {
        System.out.println("System.getProperty(\"user.dir\")+\"/\"=" + abpath);
    }

    private static BufferedWriter bw = null;

    //��ȡ������ֵ�Ŀ¼
    public static ObservableList<File> getDirsList() {

        if (dirs.size() == 0) {

            File pathtxt = new File(abpath + "path.txt");

            System.out.println("��ȡ����Ŀ¼��");

            if (!pathtxt.exists()) {
                try {
                    pathtxt.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            BufferedReader br = null;

            try {
                br = new BufferedReader(new FileReader(pathtxt));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            String dir;

            try {
                while ((dir = br.readLine()) != null) {

                    File file = new File(dir);

                    if (file.exists() && file.isDirectory()) {

                        System.out.println(file);

                        dirs.add(file);

                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {

                br.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return dirs;

        } else {

            return dirs;
        }

    }

    // ��ȡĿ¼�µ�����ý���ļ�
    public static ObservableList<Media> getMusicMedias() {

        if (medias.size() == 0) {
            System.out.println("��ȡ�����ļ���");

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

                        System.out.println(files[i]);

                        medias.add(media);
                    }
                }
            });
            return medias;
        } else {
            return medias;
        }

    }

    //��ȡĿ¼�µ������ļ�
    public static ObservableList<File> getMusicFiles() {

        if (files.size() == 0) {

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

    //����ļ��в���
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

        refreshPath();

    }

    //ɾ���ļ���
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

                int index = files.indexOf(subfiles[i]);

                medias.remove(index);

                files.remove(index);
            }
        }

        refreshPath();
    }

    //����path.txt
    public static void refreshPath() {

        File pathtxt = new File(abpath + "path.txt");

        if (!pathtxt.exists()) {

            try {
                pathtxt.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        try {

            bw = new BufferedWriter(new FileWriter(pathtxt));

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        dirs.forEach(t -> {

            // TODO Auto-generated method stub
            try {

                String s = t.getAbsolutePath();

                bw.write(s + "\r\n");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        try {
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
