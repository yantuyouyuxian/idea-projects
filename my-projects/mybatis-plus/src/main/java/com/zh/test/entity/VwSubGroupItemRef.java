package com.zh.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("T_VW_SUB_GROUP_ITEM_REF")
public class VwSubGroupItemRef implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 虚拟仓替代组ID
     */
    @TableId(value = "VW_SUB_GROUP_ID", type = IdType.ASSIGN_ID)
    private String vwSubGroupId;

    /**
     * 物料ID
     */
    @TableField("INVENTORY_ITEM_ID")
    private Integer inventoryItemId;

    /**
     * 组织ID
     */
    @TableField("ORGANIZATION_ID")
    private Integer organizationId;

    /**
     * 单位用量
     */
    @TableField("UNIT")
    private Integer unit;

    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

    @TableField("LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @TableField("VERSION")
    private Integer version;

    @TableField("IS_DELETED")
    private Integer isDeleted;


    public String getVwSubGroupId() {
        return vwSubGroupId;
    }

    public void setVwSubGroupId(String vwSubGroupId) {
        this.vwSubGroupId = vwSubGroupId;
    }

    public Integer getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Integer inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "VwSubGroupItemRef{" +
        "vwSubGroupId=" + vwSubGroupId +
        ", inventoryItemId=" + inventoryItemId +
        ", organizationId=" + organizationId +
        ", unit=" + unit +
        ", createdDate=" + createdDate +
        ", createdBy=" + createdBy +
        ", lastModifiedDate=" + lastModifiedDate +
        ", lastModifiedBy=" + lastModifiedBy +
        ", version=" + version +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
