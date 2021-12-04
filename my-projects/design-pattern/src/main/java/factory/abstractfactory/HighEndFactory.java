package factory.abstractfactory;

import factory.obj.mask.HighEndMask;
import factory.obj.mask.IMask;
import factory.obj.suit.HighEndProtectiveSuit;
import factory.obj.suit.IProtectiveSuit;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:58
 * @ Description
 */
public class HighEndFactory implements IFactory{
    @Override
    public IMask createMask() {
        return new HighEndMask();
    }

    @Override
    public IProtectiveSuit createSuit() {
        return new HighEndProtectiveSuit();
    }
}
