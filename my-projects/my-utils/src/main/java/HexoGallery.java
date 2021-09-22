import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

        for (int var7 = 0; var7 < var6; ++var7) {
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
    public void test() {
//        System.out.println(LocalDateTime.now().toString().replace("T"," "));
        String index = "001.1.1";
//        System.out.println(index.substring(0, index.lastIndexOf('.')));
//        System.out.println(index.substring(index.lastIndexOf(".")+1));

//        List<String> list = new ArrayList<>();
//        System.out.println(Optional.ofNullable(list.get(0)).orElse(null));
        List<String> strList = new ArrayList<String>() {
            private static final long serialVersionUID = 8029140068826293385L;
            {
                add("a");
                add("你好");
                add("123");
                add("1.2.");
                add(".1.2");
                add("1.1.2");
                add("1.1");
                add("11.12");
            }
        };
        for (String str : strList) {
            if (!str.matches("([1-9]+\\.)*([1-9]+)$")) {
                System.out.println(str + "   匹配不成功");
            } else {
                System.out.println(str + "   匹配成功");
            }
        }


    }

}

