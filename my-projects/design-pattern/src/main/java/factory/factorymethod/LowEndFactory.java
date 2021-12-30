package factory.factorymethod;

import factory.obj.mask.IMask;
import factory.obj.mask.LowEndMask;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:39
 * @ Description
 */
public class LowEndFactory implements IMaskFactory {

    @Override
    public IMask createMask() {
        return new LowEndMask();
    }
}
