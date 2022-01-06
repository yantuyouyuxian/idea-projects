import org.junit.Test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/20 11:50
 * @ Description
 */
public class MyTest {

    static class Person {
        String gender;
        Integer age;
        String name;
    }

    static class KdOrg implements Serializable {
        private static final long serialVersionUID = 1455451885124837472L;
        Integer fromOrg;
        Integer toOrg;

        public KdOrg(Integer fromOrg, Integer toOrg) {
            this.fromOrg = fromOrg;
            this.toOrg = toOrg;
        }
    }

    @Test
    public void test15() {
        System.out.println("aaa" + null);
    }

    @Test
    public void test14() {
        HashMap<Object, Object> map = new HashMap<>();
        int n = 16 - 1;
        System.out.println(n >> 1);
        n |= n >>> 1;
        System.out.println(n);
    }

    @Test
    public void test13() {
        LocalDateTime date1 = LocalDateTime.now();
        System.out.println(date1);
        LocalDateTime date2 = date1.plusDays(3);
        System.out.println(date2);
        LocalDateTime date3 = date1.plusDays(4);
        System.out.println(date2);


        WeekFields weekFields = WeekFields.ISO;
//        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        System.out.println("date1的周数" + date1.get(weekFields.weekOfWeekBasedYear()));
        System.out.println("date2的周数" + date2.get(weekFields.weekOfWeekBasedYear()));
        System.out.println("date3的周数" + date3.get(weekFields.weekOfWeekBasedYear()));
        System.out.println("date1,date2的间隔周数:" + ChronoUnit.WEEKS.between(date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)), date2));
        System.out.println("date1,date3的间隔周数:" + ChronoUnit.WEEKS.between(date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)), date3));
        System.out.println("根据date1得到date2的周数" + (date1.get(weekFields.weekOfWeekBasedYear()) + ChronoUnit.WEEKS.between(date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)), date2)));
        System.out.println("根据date1得到date3的周数" + (date1.get(weekFields.weekOfWeekBasedYear()) + ChronoUnit.WEEKS.between(date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)), date3)));
    }

    @Test
    public void test12() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek().equals(DayOfWeek.SUNDAY));
    }

    @Test
    public void test11() {
        HashSet<Integer> set = new HashSet<Integer>() {
            private static final long serialVersionUID = -1903955700240581078L;

            {
                add(1);
                add(2);
                add(3);
            }
        };
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>() {
            private static final long serialVersionUID = 4095167663872143809L;

            {
                put(1, set);
            }
        };
        map.get(1).add(4);
        map.getOrDefault(2, set);
        System.out.println(map.toString());
        System.out.println(set.toString());
    }

    @Test
    public void test10() {
        String config = "MDS_REWRITE_TYPE_";
        String configName = "MDS_REWRITE_TYPE_KD_SO_96";
        String configValue = "KD_MDS";
        System.out.println(configName.substring(config.length()));
        String typeOrg = configName.substring(config.length());
        System.out.println(typeOrg.substring(0, typeOrg.lastIndexOf("_")));
        System.out.println(typeOrg.substring(typeOrg.lastIndexOf("_") + 1));
    }

    @Test
    public void test09() {
        String directory = "APPS";
        String createMdsRemainDemandSupplyTableSql = "CREATE TABLE \"" + directory + "\".\"CUX_ISC_MDS_REMAIN_RELEASE\"" +
                "   (RESULT_ID NUMBER(20,0) NOT NULL ENABLE, " +
                "ORGANIZATION_ID   NUMBER(20,0), " +
                "INVENTORY_ITEM_ID   NUMBER(20,0), " +
                "SCHEDULE_DATE   DATE, " +
                "CUST_CODE   CHAR(30), " +
                "MDS_SCHEDULE_DESIGNER   VARCHAR2(255), " +
                "MPS_TRANSACTION_ID    NUMBER(20,0), " +
                "ORIGIN_SCHEDULE_QTY    NUMBER(30,8), " +
                "SCHEDULE_QTY    NUMBER(30,8), " +
                "IS_NEW    CHAR(32) " +
                "   ) SEGMENT CREATION IMMEDIATE  " +
                "  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255  " +
                " NOCOMPRESS LOGGING " +
                "  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645 " +
                "  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 " +
                "  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT) " +
                "  TABLESPACE   APPS_TS_TX_DATA  ";
        String createLogTableSql = "CREATE TABLE \"" + directory + "\".\"CUX_ISC_CAL_RESULT_LOG\"" +
                "   (RESULT_ID NUMBER(20,0) NOT NULL ENABLE," +
                " HISTORY_ID NUMBER(20,0) NOT NULL ENABLE," +
                "TYPE VARCHAR2(32) NOT NULL ENABLE, " +
                "STATUS NUMBER(10,0) DEFAULT 0 NOT NULL ENABLE, " +
                "IS_DELETED NUMBER(1,0) DEFAULT 0 NOT NULL ENABLE, " +
                "CREATED_BY CHAR(32) NOT NULL ENABLE," +
                "CREATED_DATE DATE NOT NULL ENABLE," +
                "LAST_MODIFIED_BY CHAR(32) NOT NULL ENABLE, " +
                "LAST_MODIFIED_DATE DATE NOT NULL ENABLE, " +
                "VERSION NUMBER(10,0) DEFAULT 0 NOT NULL ENABLE," +
                "PRIMARY KEY (RESULT_ID)" +
                "  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS " +
                "  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645" +
                "  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1" +
                "  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)" +
                "  TABLESPACE APPS_TS_TX_DATA ENABLE" +
                "   ) SEGMENT CREATION IMMEDIATE " +
                "  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 " +
                " NOCOMPRESS LOGGING" +
                "  STORAGE(INITIAL 131072 NEXT 131072 MINEXTENTS 1 MAXEXTENTS 2147483645" +
                "  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1" +
                "  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)" +
                "  TABLESPACE APPS_TS_TX_DATA";
        System.out.println(createMdsRemainDemandSupplyTableSql);
        System.out.println(createLogTableSql);
    }

    @Test
    public void test08() {
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).withHour(0).withMinute(0).withSecond(0).withNano(0));

        String str1 = "aaa_bbb";
        String str2 = "aaa_";
        String str3 = "aaa";
        System.out.println(str1.split("_").length);
        System.out.println(str2.split("_").length);
        System.out.println(str3.split("_").length);


    }

    @Test
    public void test07() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
            private static final long serialVersionUID = -1903955700240581078L;

            {
                put(1, 2);
                put(2, 3);
                put(3, 4);
            }
        };
        map.forEach((k, v) -> {
            if (k == 2) {
                return;
            }
            System.out.println(k + " : " + v);
        });
    }

    @Test
    public void test06() {
        Map<String, List<KdOrg>> kdOrgMap = new HashMap<>();
        List<KdOrg> kdOrgs = new ArrayList<KdOrg>() {
            private static final long serialVersionUID = -1903955700240581078L;

            {
                add(new KdOrg(1, 2));
                add(new KdOrg(2, 3));
            }
        };
        kdOrgMap.put("vw1", kdOrgs);
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
