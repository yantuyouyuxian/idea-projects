import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/20 11:50
 * @ Description
 */
public class MyTest {

    class Person {
        String gender;
        Integer age;
        String name;
    }

    class KdOrg implements Serializable {
        private static final long serialVersionUID = 1455451885124837472L;
        Integer fromOrg;
        Integer toOrg;
        public KdOrg(Integer fromOrg, Integer toOrg) {
            this.fromOrg = fromOrg;
            this.toOrg = toOrg;
        }
    }

    @Test
    public void test06() {
        Map<String, List<KdOrg>> kdOrgMap = new HashMap<>();
        ArrayList<KdOrg> kdOrgs = new ArrayList<KdOrg>(){
            {
                add(new KdOrg(1,2));
                add(new KdOrg(2,3));
            }
        };
        kdOrgMap.put("vw1",kdOrgs);
        System.out.println(kdOrgMap.toString());
    }

    @Test
    public void test05() {
        Map<String, List<String>> map = new HashMap<>();
        map.put(null, Arrays.asList("1", "2", "3"));
        System.out.println(map.get(null));
    }

    @Test
    public void test04() {
        List<Integer> list = Arrays.asList(1, 2, 4, 4, 5);
        String str = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(str);
        List<String> strList = Arrays.asList("1", "2", "3");
        System.out.println(String.join(",", strList));
    }

    @Test
    public void test01() {
        System.out.println(compare(new BigDecimal("2.0"), new BigDecimal("4.0"), "ASC"));
        System.out.println(compare(new BigDecimal("2.0"), new BigDecimal("4.0"), "DESC"));
    }

    @Test
    public void test02() {
        BigDecimal b1 = new BigDecimal("16");
        BigDecimal b2 = new BigDecimal("5");
        System.out.println(b1.divide(b2, 9, BigDecimal.ROUND_UP));
    }

    @Test
    public void test03() {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
    }

    private int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
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
