package factory.obj.mask;

import factory.obj.mask.IMask;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/4 21:31
 * @ Description
 */
public class LowEndMask implements IMask {
    @Override
    public void show() {
        System.out.println("低端口罩");
    }
}
