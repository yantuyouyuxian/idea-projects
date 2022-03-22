package com.zh.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/17 17:17
 * @ Description
 */
public class ExcelTest {
    public static void main(String[] args) {

    }

    @Test
    public void testSheet() {
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriterBuilder builder = EasyExcel.write(fileName);
        ExcelWriter excelWriter = builder.build();
        WriteSheet sheet1 = builder.sheet(0, "sheet1").build();
        excelWriter.write(data(),sheet1);
        WriteSheet sheet2 = builder.sheet(1,"sheet2").build();
        excelWriter.write(data(),sheet2);
        excelWriter.finish();
    }

    @Test
    public void test3() {
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriterBuilder builder = EasyExcel.write(fileName);
        MyStrategy strategy = new MyStrategy();
        ExcelWriterSheetBuilder sheetBuilder = builder.sheet("sheet1");
        sheetBuilder.doWrite(data());
        sheetBuilder.registerWriteHandler(strategy);

    }

    @Test
    public void test2() {
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }

    @Test
    public void myTest1() {
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter writer = EasyExcel.write(fileName).build();
        WriteSheet sheet1 = EasyExcel.writerSheet("sheet1").build();
        WriteTable table1 = EasyExcel.writerTable(1).build();
        List<List<String>> tableHead = new ArrayList<List<String>>() {
            private static final long serialVersionUID = 4662680106858560592L;

            {
                add(Collections.singletonList("字符串表题"));
                add(Collections.singletonList("日期表题"));
                add(Collections.singletonList("数字表题"));
            }
        };
        table1.setHead(tableHead);


        Map<String, Object> infoMap = new HashMap<String, Object>() {
            private static final long serialVersionUID = -1426957302986413260L;

            {
                put("日期：", LocalDateTime.now());
                put("姓名：", "张寒");
            }
        };
        List<List<Object>> info = new ArrayList<>();
        infoMap.forEach((k, v) -> {
            List<Object> row = new ArrayList<>();
            row.add(k);
            row.add(v);
            info.add(row);
        });

        writer.write(info, sheet1);
        writer.write(data(), sheet1, table1);
        writer.finish();
    }

    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });


        // 写法2
        fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());


        // 写法3
        fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(LocalDateTime.now());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
