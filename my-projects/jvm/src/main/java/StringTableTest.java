/**
 * @ Author         zhangHan
 * @ Date           2022/1/27 21:53
 * @ Description
 */
public class StringTableTest {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        s1 = s1.intern();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);


    }
}
