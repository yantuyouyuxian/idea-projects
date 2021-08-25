package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试Check注解标记的方法
 */
public class TestChek {
    public static void main(String[] args) throws IOException {
        // 创建计算器对象
        Calculator calculator=new Calculator();
        // 获取字节码文件对象
        Class c=calculator.getClass();
        // 获取所有方法
        Method[] methods=c.getMethods();
        // 判断方法是否又check注解
        // 有就执行
        int num=0;//出现异常的次数
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------");
                    bw.newLine();
//                    e.printStackTrace();
                }
            }
        }
        bw.write("一共"+num+"次异常");
        // 捕获异常
        bw.flush();
        bw.close();
    }
}
