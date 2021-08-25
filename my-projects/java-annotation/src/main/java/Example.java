import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 可以创建任意对象，执行任意方法
 * 类名和方法定义在配置文件中
 * 加载读取配置文件
 * 创建对象，执行方法
 */
@Pro(className = "com.zh.Demo1",methodName = "show")
public class Example {
    public static void main(String[] args) throws Exception {
        // 解析注解
        Class exampleClass = Example.class;
        // 获取上边的注解
        // 实际就是在内存中生成了一个该注解接口的子类实现对象
        Pro annotation = (Pro) exampleClass.getAnnotation(Pro.class);
        // 调用注解的方法获取设置的属性
        String className=annotation.className();
        String methodName=annotation.methodName();

        System.out.println(className);
        System.out.println(methodName);


        Class aClass = Class.forName(className);

        Object obj=aClass.newInstance();

        Method method = aClass.getMethod(methodName);

        method.invoke(obj);
    }
}
