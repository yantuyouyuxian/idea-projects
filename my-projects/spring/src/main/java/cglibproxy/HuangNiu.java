package cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ Author         zhangHan
 * @ Date           2021/11/24 11:50
 * @ Description
 */
public class HuangNiu implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("黄牛帮忙代购");
        return methodProxy.invokeSuper(o, objects);
    }

    public static void main(String[] args) {
        HuangNiu huangNiu = new HuangNiu();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CommonPerson.class);
        enhancer.setCallback(huangNiu);

        CommonPerson person = (CommonPerson) enhancer.create();
        person.buyTicket();
    }
}
