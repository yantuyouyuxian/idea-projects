package com.zh.test.entity;

import java.math.BigDecimal;
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
@TableName("T_VW_ITEM_REF")
public class VwItemRef implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 虚拟仓ID
     */
    @TableField("VW_ID")
    private String vwId;

    /**
     * 物料ID
     */
    @TableField("INVENTORY_ITEM_ID")
    private Integer inventoryItemId;

    /**
     * 库存组织ID
     */
    @TableField("ORGANIZATION_ID")
    private Integer organizationId;

    /**
     * 原始数量
     */
    @TableField("ORIGIANAL_QUANTITY")
    private BigDecimal origianalQuantity;

    /**
     * 冲减剩余数量
     */
    @TableField("OFFSETED_QUANTITY")
    private BigDecimal offsetedQuantity;

    /**
     * 交易ID
     */
    @TableField("TRANSACTION_ID")
    private Long transactionId;

    /**
     * 交易时间
     */
    @TableField("TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    /**
     * 手动维护类型，补损或者调整
     */
    @TableField("MANUAL_TYPE")
    private String manualType;

    /**
     * 手动维护数量，补损是减一个非负数；调整直接加
     */
    @TableField("MANUAL_QUANTITY")
    private BigDecimal manualQuantity;

    /**
     * 初始为1，冲减剩余数量为0后，值为0
     */
    @TableField("STATUS")
    private Integer status;

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVwId() {
        return vwId;
    }

    public void setVwId(String vwId) {
        this.vwId = vwId;
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

    public BigDecimal getOrigianalQuantity() {
        return origianalQuantity;
    }

    public void setOrigianalQuantity(BigDecimal origianalQuantity) {
        this.origianalQuantity = origianalQuantity;
    }

    public BigDecimal getOffsetedQuantity() {
        return offsetedQuantity;
    }

    public void setOffsetedQuantity(BigDecimal offsetedQuantity) {
        this.offsetedQuantity = offsetedQuantity;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getManualType() {
        return manualType;
    }

    public void setManualType(String manualType) {
        this.manualType = manualType;
    }

    public BigDecimal getManualQuantity() {
        return manualQuantity;
    }

    public void setManualQuantity(BigDecimal manualQuantity) {
        this.manualQuantity = manualQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "VwItemRef{" +
        "id=" + id +
        ", vwId=" + vwId +
        ", inventoryItemId=" + inventoryItemId +
        ", organizationId=" + organizationId +
        ", origianalQuantity=" + origianalQuantity +
        ", offsetedQuantity=" + offsetedQuantity +
        ", transactionId=" + transactionId +
        ", transactionDate=" + transactionDate +
        ", manualType=" + manualType +
        ", manualQuantity=" + manualQuantity +
        ", status=" + status +
        ", createdDate=" + createdDate +
        ", createdBy=" + createdBy +
        ", lastModifiedDate=" + lastModifiedDate +
        ", lastModifiedBy=" + lastModifiedBy +
        ", version=" + version +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
