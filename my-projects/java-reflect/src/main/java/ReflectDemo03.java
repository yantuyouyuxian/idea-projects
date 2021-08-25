import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射获取构造方法
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass=Person.class;

        // 通过构造器构造对象，这里为有参的构造函数，也可以获取无参构造
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object p = constructor.newInstance("name",23);
        System.out.println(p);

        // 空参构造对象可以直接使用class的newInstance()方法
        Object o = personClass.newInstance();
        System.out.println(o);

//        constructor.setAccessible();
    }
}
