package com.zh.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangHan
 * @since 2021-10-11
 */
@TableName("T_VW_VW_SUB_SET_REF")
public class VwVwSubSetRef implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 虚拟仓ID
     */
    @TableId(value = "VW_ID", type = IdType.ASSIGN_ID)
    private String vwId;

    /**
     * 虚拟仓替代组ID
     */
    @TableField("VW_SUB_SET_ID")
    private String vwSubSetId;


    public String getVwId() {
        return vwId;
    }

    public void setVwId(String vwId) {
        this.vwId = vwId;
    }

    public String getVwSubSetId() {
        return vwSubSetId;
    }

    public void setVwSubSetId(String vwSubSetId) {
        this.vwSubSetId = vwSubSetId;
    }

    @Override
    public String toString() {
        return "VwVwSubSetRef{" +
        "vwId=" + vwId +
        ", vwSubSetId=" + vwSubSetId +
        "}";
    }
}
