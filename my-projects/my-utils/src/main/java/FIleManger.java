import java.io.File;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/5 1:00
 * @ Description
 */
public class FIleManger {
    public static void main(String[] args) {
        String source = "C:\\eclipse-workspace\\workspace_fx_backup";
        File file = new File(source);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File project : files) {
                if (project.isDirectory()) {
                    File[] projectFiles = project.listFiles();
                    for (File projectFile : projectFiles) {
                        String fileName = projectFile.getName();
                        if (fileName.equals("bin") ||
                                fileName.equals(".classpath") ||
                                fileName.equals(".project") ||
                                fileName.endsWith(".iml")) {
                            projectFile.delete();
                        }
                    }
                }
            }
        }
    }
}
