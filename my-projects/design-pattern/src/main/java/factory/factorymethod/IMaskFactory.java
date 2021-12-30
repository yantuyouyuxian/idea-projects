package factory.factorymethod;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:32
 * @ Description
 */

import factory.obj.mask.IMask;

/**
 * 工厂方法模式
 *
 */
public interface IMaskFactory {
    IMask createMask();
}
