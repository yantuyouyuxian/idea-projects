import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ Author       zhangHan
 * @ Date         2021/7/17 21:31
 * @ Description
 */
public class HexoGallery {

    public static void main(String[] args) {
        File wallpaper = new File("D:\\blog\\github-blog\\source\\img\\wallpaper");
        Set<String> imgTail = new HashSet();
        imgTail.addAll(Arrays.asList(".jpg", ".jpeg", ".png"));
        File[] files = wallpaper.listFiles();
        StringBuilder sb = new StringBuilder("{% gallery %}\n");
        File[] var5 = files;
        int var6 = files.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            File file = var5[var7];
            String fileTail = file.getName().substring(file.getName().indexOf("."));
            if (imgTail.contains(fileTail)) {
                sb.append("![](/img/wallpaper/" + file.getName() + ")\n");
            }
        }

        sb.append("{% endgallery %}");
        System.out.println(sb.toString());
    }

    @Test
    public void test(){
        System.out.println(Objects.equals(null,new Integer(1)));
    }

}

