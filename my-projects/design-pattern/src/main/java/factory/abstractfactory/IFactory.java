package factory.abstractfactory;

import factory.obj.mask.IMask;
import factory.obj.suit.IProtectiveSuit;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:57
 * @ Description
 */
public interface IFactory {
    IMask createMask();
    IProtectiveSuit createSuit();
}
