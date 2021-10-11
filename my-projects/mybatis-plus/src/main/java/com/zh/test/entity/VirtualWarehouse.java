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
@TableName("T_VIRTUAL_WAREHOUSE")
public class VirtualWarehouse implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 虚拟仓ID
     */
    @TableId(value = "VIRTUAL_WAREHOUSE_ID", type = IdType.ASSIGN_ID)
    private String virtualWarehouseId;

    /**
     * 客户主键ID
     */
    @TableField("CUSTOMER_ID")
    private Integer customerId;

    /**
     * 区域类型
     */
    @TableField("ZONE_TYPE")
    private String zoneType;

    /**
     * 虚拟仓名称
     */
    @TableField("VIRTUAL_WAREHOUSE_NAME")
    private String virtualWarehouseName;

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

    @TableField("NULL_IDENT")
    private String nullIdent;


    public String getVirtualWarehouseId() {
        return virtualWarehouseId;
    }

    public void setVirtualWarehouseId(String virtualWarehouseId) {
        this.virtualWarehouseId = virtualWarehouseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public String getVirtualWarehouseName() {
        return virtualWarehouseName;
    }

    public void setVirtualWarehouseName(String virtualWarehouseName) {
        this.virtualWarehouseName = virtualWarehouseName;
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

    public String getNullIdent() {
        return nullIdent;
    }

    public void setNullIdent(String nullIdent) {
        this.nullIdent = nullIdent;
    }

    @Override
    public String toString() {
        return "VirtualWarehouse{" +
        "virtualWarehouseId=" + virtualWarehouseId +
        ", customerId=" + customerId +
        ", zoneType=" + zoneType +
        ", virtualWarehouseName=" + virtualWarehouseName +
        ", createdDate=" + createdDate +
        ", createdBy=" + createdBy +
        ", lastModifiedDate=" + lastModifiedDate +
        ", lastModifiedBy=" + lastModifiedBy +
        ", version=" + version +
        ", isDeleted=" + isDeleted +
        ", nullIdent=" + nullIdent +
        "}";
    }
}
