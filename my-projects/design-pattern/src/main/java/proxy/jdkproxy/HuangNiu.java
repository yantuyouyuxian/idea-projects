package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author         zhangHan
 * @ Date           2021/11/24 11:47
 * @ Description
 */
public class HuangNiu implements InvocationHandler {

    private final CommonPerson target;

    public HuangNiu(CommonPerson target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("黄牛帮忙代购");
        return method.invoke(target, args);
    }

    /**
     * 1、被代理的类需要实现某个接口，比如这里的CommonPerson类实现了BuyTicket接口。
     * 2、代理某个方法需要实现InvocationHandler接口
     * 3、通过Proxy.newProxyInstance生成代理对象
     */
    public static void main(String[] args) {
        //需要被代理的类
        CommonPerson commonPerson = new CommonPerson();

        //代理类
        HuangNiu huangNiu = new HuangNiu(commonPerson);

        //生成代理对象
        BuyTicket buyTicket = (BuyTicket) Proxy.newProxyInstance(CommonPerson.class.getClassLoader(), new Class[]{BuyTicket.class}, huangNiu);

        //调用代理对象的方法
        buyTicket.buyTicket();

    }

}
