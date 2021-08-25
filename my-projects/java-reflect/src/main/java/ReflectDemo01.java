/**
 * 获取Class对象的三种方式
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class.forName();
        Class cls1=Class.forName("com.zh.Person");
        System.out.println(cls1);

        // 2.类名.class
        Class cls2=Person.class;
        System.out.println(cls2);

        // 3.类名.class;
        Person person=new Person();
        Class cls3=person.getClass();
        System.out.println(cls3);

        // 比较三个Class，为同一个Class对象
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
