import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 可以创建任意对象，执行任意方法
 * 类名和方法定义在配置文件中
 * 加载读取配置文件
 * 创建对象，执行方法
 */
public class Example {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 加载配置文件
        Properties properties=new Properties();
        ClassLoader classLoader = Example.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        properties.load(is);

        // 获取配置文件中定义的数据
        String className=properties.getProperty("className");
        String methodName=properties.getProperty("methodName");

        // 加载配置的类和方法
        Class aClass = Class.forName(className);
        Object obj=aClass.newInstance();
        Method method=aClass.getMethod(methodName);
        method.invoke(obj);

    }
}
