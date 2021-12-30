package factory;

import factory.abstractfactory.HighEndFactory;
import factory.abstractfactory.IFactory;
import factory.abstractfactory.LowEndFactory;
import factory.obj.mask.IMask;
import factory.obj.suit.IProtectiveSuit;


/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:42
 * @ Description
 */
public class Test {
    public static void main(String[] args) {
        // 简单工厂模式
        // 根据传入的参数创建不同的对象

//        MaskFactory factory = new MaskFactory();
//        IMask mask1 = factory.createMask("高端口罩");
//        IMask mask2 = factory.createMask("低端口罩");
//        mask1.show();
//        mask2.show();


        // 工厂方法模式
        // 将工厂抽象为接口，不同的对象对应一个子类工厂
//        IMaskFactory factory1 = new LowEndFactory();
//        IMaskFactory factory2 = new HighEndFactory();
//        IMask mask1 = factory1.createMask();
//        IMask mask2 = factory2.createMask();
//        mask1.show();
//        mask2.show();

        // 抽象工厂模式
        // 当子类非常多时，我们不能说是给每个子类都新建一个工厂类
        // 这时候就可以将类进行分组，不同组的类，对应一个子类工厂
        IFactory factory1 = new LowEndFactory();
        IFactory factory2 = new HighEndFactory();
        IMask mask1 = factory1.createMask();
        IProtectiveSuit suit1 = factory1.createSuit();

        IMask mask2 = factory2.createMask();
        IProtectiveSuit suit2 = factory2.createSuit();
        mask1.show();
        mask2.show();
        suit1.showSuit();
        suit2.showSuit();

    }
}
