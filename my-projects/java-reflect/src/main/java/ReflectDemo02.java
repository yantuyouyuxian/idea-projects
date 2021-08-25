import java.lang.reflect.Field;
/**
    通过反射获取Field
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cls1=Person.class;


        Field[] fields=cls1.getFields();// 只能获取public成员变量
        for (Field field : fields) {
            System.out.println(field);
        }

        Field field=cls1.getField("a");
        Person p=new Person();
        Object obj=field.get(p);
        System.out.println(obj);
        field.set(p,"张三");
        System.out.println(p);
        obj=field.get(p);
        System.out.println(obj);
        System.out.println("==============================================");



        Field[] declaredFields=cls1.getDeclaredFields(); //获取所有的成员变量
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field field1=cls1.getDeclaredField("name");
        //忽略安全检查
        field1.setAccessible(true);//暴力反射
        Object obj1=field1.get(p);
        System.out.println(obj1);
    }
}
