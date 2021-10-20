import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/20 11:50
 * @ Description
 */
public class MyTest {

    @Test
    public void test01(){
        System.out.println(compare(new BigDecimal("2.0"),new BigDecimal("4.0"),"ASC"));
        System.out.println(compare(new BigDecimal("2.0"),new BigDecimal("4.0"),"DESC"));
    }
    @Test
    public void test(){
        BigDecimal b1 = new BigDecimal("16");
        BigDecimal b2 = new BigDecimal("5");
        System.out.println(b1.divide(b2, 9, BigDecimal.ROUND_UP));
    }

    private int compare(BigDecimal sourceQty, BigDecimal targetQty, String order) {
        if ("ASC".equals(order)) {
            return sourceQty.compareTo(targetQty);
        } else if ("DESC".equals(order)) {
            return targetQty.compareTo(sourceQty);
        } else {
            return 0;
        }
    }
}
