package factory.abstractfactory;

import factory.obj.mask.IMask;
import factory.obj.mask.LowEndMask;
import factory.obj.suit.IProtectiveSuit;
import factory.obj.suit.LowEndProtectiveSuit;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:58
 * @ Description
 */
public class LowEndFactory implements IFactory{
    @Override
    public IMask createMask() {
        return new LowEndMask();
    }

    @Override
    public IProtectiveSuit createSuit() {
        return new LowEndProtectiveSuit();
    }
}
