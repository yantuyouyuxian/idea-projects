import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
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
import java.util.Objects;
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

    public class NoAccessClass {
        private String noAccessField = "12345";
    }

    class Car {
        private String id;
        //other info...
    }

    class Park {
        private String id;
        //other info...
    }

    class Fee {
        private String carId;
        private String parkId;
        private LocalDateTime inTime;
        private LocalDateTime outTime;
        private BigDecimal fee;
    }

    @Test
    public void test21() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Integer value = map.computeIfAbsent(1, v -> new HashMap<>()).computeIfAbsent(2, v -> 3);
        value = 4;
        System.out.println(map);
    }

    @Test
    public void test20() {
        float percentage = 100f;

        BigDecimal avgRequiredQuantity = new BigDecimal(25551).multiply(BigDecimal.valueOf((Objects.nonNull(percentage) ? Float.valueOf(percentage) : 0f) / Float.valueOf(percentage))).setScale(0, BigDecimal.ROUND_UP);
        System.out.println(avgRequiredQuantity);
    }

    @Test
    public void test19() {
//        final String s = "AAA";
//        List list = new ArrayList();
//        list.add("aaa");
//        System.out.println(list.size());
//        Set set = new HashSet();
//        set.add("aa");
//        set.add("aa");
//        System.out.println(set);

    }

    @Test
    public void test18() throws IllegalAccessException {
        NoAccessClass aa = new NoAccessClass();
        Class<? extends NoAccessClass> c = aa.getClass();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(aa));
        }
    }

    @Test
    public void test17() {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);
        getData(name); // 1
        getData(age); // 2
        getData(number); // 3
//        getUpperNumberData(name); // 4
        getUpperNumberData(age); // 5
        getUpperNumberData(number); // 6
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getUpperNumberData(Box<? extends Number> data) {
        System.out.println("data :" + data.getData());
    }

    static class Box<T> {
        private T data;

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    @Test
    public void test16() throws IOException {
//        int w = 0;
//        for (int x = 0; x < 5; x++) {
//            for (int y = 0; y < 100; y++) {
//                if (x == 3) {
//                    break;
//                }
//                w++;
//            }
//        }
//        System.out.println("w = " + w);

//        new BufferedWriter(new FileWriter("a.txt"));
//        new BufferedReader(new FileInputStream("a.dat"));
//        new GZIPOutputStream(new FileOutputStream("a.zip"));
//        new ObjectInputStream(new FileInputStream("a.dat"));

//        int m = 5, n = 6;
//        int x = (m++) + n;
//        int y = (-m) + n;
//        System.out.print("x=" + x + ",");
//        System.out.println("y=" + y);

//        Integer i1 = new Integer(10);
//        Integer i2 = new Integer(10);
//        Integer i3 = Integer.valueOf(10);
//        Integer i4 = Integer.valueOf(10);
//        System.out.println(i1 == i2);
//        System.out.println(i1.equals(i2));
//        System.out.println(i2 == i3);
//        System.out.println(i3 == i4);

//        try {
//            int num1 = 1;
//            int num2 = 0;
//            int result = num1 / num2;
//            System.out.println(result);
//            throw new NumberFormatException();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(1);
//        } catch (NumberFormatException e) {
//            System.out.println(2);
//        } catch (Exception e) {
//            System.out.println(3);
//        } finally {
//            System.out.println(4);
//        }
//        System.out.println(5);

//        List<String> strings = new ArrayList<>(7);
//        strings.add("四");
//        strings.add("一");
//        strings.add("九八");
//        strings.add("三");
//        strings.add("五");
//        strings.add("九");
//        strings.add("三六");
//
//        List<String> filteredStrings = strings.stream().filter(e -> !e.contains("九")).collect(Collectors.toList());
//        System.out.println(filteredStrings);

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("开发人员开发新需求功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();

    }

    @Test
    public void test15() {
        System.out.println("aaa" + null);
        List<String> list = new ArrayList<>();
        list.add(new String("aaa"));
        list.add("bbb");
        System.out.println(list.contains(new String("aaa")));
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
