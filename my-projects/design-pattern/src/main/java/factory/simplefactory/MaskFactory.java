package factory.simplefactory;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:32
 * @ Description
 */

import factory.obj.mask.HighEndMask;
import factory.obj.mask.IMask;
import factory.obj.mask.LowEndMask;

/**
 * 简单工厂模式
 * 根据传入的参数创建不同的对象
 * 缺点：每个新的对象都要加入对象的参数判断，不符合开闭原则
 */
public class MaskFactory {
    public IMask createMask(String type) {
        IMask mask = null;
        if ("高端口罩".equals(type)) {
            mask = new HighEndMask();
        } else if ("低端口罩".equals(type)) {
            mask = new LowEndMask();
        }
        return mask;
    }
}
