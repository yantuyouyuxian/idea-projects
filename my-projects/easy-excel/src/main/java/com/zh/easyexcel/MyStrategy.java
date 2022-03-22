package com.zh.easyexcel;

import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/18 10:03
 * @ Description
 */
public class MyStrategy extends AbstractCellStyleStrategy {


    @Override
    protected void setHeadCellStyle(CellWriteHandlerContext context) {
        Workbook workbook = context.getWriteWorkbookHolder().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillBackgroundColor((short) 20);
        super.setHeadCellStyle(context);
    }

    @Override
    protected void setContentCellStyle(CellWriteHandlerContext context) {
        super.setContentCellStyle(context);
    }

//    @Override
//    protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
//        super.setHeadCellStyle(cell, head, relativeRowIndex);
//    }
//
//    @Override
//    protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
//        super.setContentCellStyle(cell, head, relativeRowIndex);
//    }
}
