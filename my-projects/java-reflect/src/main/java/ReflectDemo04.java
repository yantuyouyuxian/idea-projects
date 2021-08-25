import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class;

        Method eat_method = personClass.getMethod("eat");
        Person person=new Person();
        eat_method.invoke(person);


        eat_method=personClass.getMethod("eat",String.class);
        eat_method.invoke(person,"饭");


        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());//获取方法名
            System.out.println(personClass.getName());//获取类名
        }

//        personClass.getDeclaredMethods()
//        method.setAccessible()
//        method.getName()
//        personClass.getName()

    }
}
