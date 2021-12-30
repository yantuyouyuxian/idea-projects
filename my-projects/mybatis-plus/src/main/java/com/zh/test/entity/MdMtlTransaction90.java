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
 * 基础数据 - 事务处理记录
 * </p>
 *
 * @author zhangHan
 * @since 2021-10-21
 */
@TableName("T_MD_MTL_TRANSACTION_90")
public class MdMtlTransaction90 implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 交易ID
     */
    @TableId(value = "TRANSACTION_ID", type = IdType.ASSIGN_ID)
    private Long transactionId;

    /**
     * 交易日期
     */
    @TableField("TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    /**
     * 组织ID
     */
    @TableField("ORGANIZATION_ID")
    private Integer organizationId;

    /**
     * 料号ID
     */
    @TableField("ITEM_ID")
    private Integer itemId;

    /**
     * 子库编码
     */
    @TableField("SUBINVENTORY_CODE")
    private String subinventoryCode;

    /**
     * 交易类型ID
     */
    @TableField("TRANSACTION_TYPE_ID")
    private Integer transactionTypeId;

    /**
     * 交易活动ID
     */
    @TableField("TRANSACTION_ACTION_ID")
    private Integer transactionActionId;

    /**
     * 交易单据类型ID
     */
    @TableField("TRANSACTION_SOURCE_TYPE_ID")
    private Integer transactionSourceTypeId;

    /**
     * 交易单据ID
     */
    @TableField("TRANSACTION_SOURCE_ID")
    private Long transactionSourceId;

    /**
     * 交易数量
     */
    @TableField("TRANSACTION_QUANTITY")
    private BigDecimal transactionQuantity;

    /**
     * 单位
     */
    @TableField("TRANSACTION_UOM")
    private String transactionUom;

    /**
     * 交易参考
     */
    @TableField("TRANSACTION_REFERENCE")
    private String transactionReference;

    /**
     * 交易至组织ID
     */
    @TableField("TRANSFER_ORGANIZATION_ID")
    private Integer transferOrganizationId;

    /**
     * 交易至子库
     */
    @TableField("TRANSFER_SUBINVENTORY")
    private String transferSubinventory;

    /**
     * 物权所属组织ID
     */
    @TableField("OWNING_ORGANIZATION_ID")
    private Integer owningOrganizationId;

    /**
     * 交易至ID
     */
    @TableField("TRANSFER_TRANSACTION_ID")
    private Long transferTransactionId;

    /**
     * PO/SO/WIP/TRANSFER
     */
    @TableField("IBP_SOURCE_TYPE")
    private String ibpSourceType;

    /**
     * 对应IBP的ID
     */
    @TableField("IBP_SOURCE_ID")
    private Long ibpSourceId;

    /**
     * 对应IBP的单据号
     */
    @TableField("IBP_SOURCE_NO")
    private String ibpSourceNo;

    /**
     * 发料事务处理对应发料单行ID
     */
    @TableField("SOURCE_LINE_ID")
    private Long sourceLineId;

    /**
     * RCV_TRANSACTION的交易ID
     */
    @TableField("RCV_TRANSACTION_ID")
    private Long rcvTransactionId;

    /**
     * ERP里的创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * ERP里的创建日期
     */
    @TableField("CREATION_DATE")
    private LocalDateTime creationDate;

    /**
     * 数据创建时间
     */
    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;

    /**
     * 数据更新时间
     */
    @TableField("LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;


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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getSubinventoryCode() {
        return subinventoryCode;
    }

    public void setSubinventoryCode(String subinventoryCode) {
        this.subinventoryCode = subinventoryCode;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Integer getTransactionActionId() {
        return transactionActionId;
    }

    public void setTransactionActionId(Integer transactionActionId) {
        this.transactionActionId = transactionActionId;
    }

    public Integer getTransactionSourceTypeId() {
        return transactionSourceTypeId;
    }

    public void setTransactionSourceTypeId(Integer transactionSourceTypeId) {
        this.transactionSourceTypeId = transactionSourceTypeId;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

    public BigDecimal getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(BigDecimal transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public String getTransactionUom() {
        return transactionUom;
    }

    public void setTransactionUom(String transactionUom) {
        this.transactionUom = transactionUom;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public Integer getTransferOrganizationId() {
        return transferOrganizationId;
    }

    public void setTransferOrganizationId(Integer transferOrganizationId) {
        this.transferOrganizationId = transferOrganizationId;
    }

    public String getTransferSubinventory() {
        return transferSubinventory;
    }

    public void setTransferSubinventory(String transferSubinventory) {
        this.transferSubinventory = transferSubinventory;
    }

    public Integer getOwningOrganizationId() {
        return owningOrganizationId;
    }

    public void setOwningOrganizationId(Integer owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
    }

    public Long getTransferTransactionId() {
        return transferTransactionId;
    }

    public void setTransferTransactionId(Long transferTransactionId) {
        this.transferTransactionId = transferTransactionId;
    }

    public String getIbpSourceType() {
        return ibpSourceType;
    }

    public void setIbpSourceType(String ibpSourceType) {
        this.ibpSourceType = ibpSourceType;
    }

    public Long getIbpSourceId() {
        return ibpSourceId;
    }

    public void setIbpSourceId(Long ibpSourceId) {
        this.ibpSourceId = ibpSourceId;
    }

    public String getIbpSourceNo() {
        return ibpSourceNo;
    }

    public void setIbpSourceNo(String ibpSourceNo) {
        this.ibpSourceNo = ibpSourceNo;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public Long getRcvTransactionId() {
        return rcvTransactionId;
    }

    public void setRcvTransactionId(Long rcvTransactionId) {
        this.rcvTransactionId = rcvTransactionId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "MdMtlTransaction90{" +
        "transactionId=" + transactionId +
        ", transactionDate=" + transactionDate +
        ", organizationId=" + organizationId +
        ", itemId=" + itemId +
        ", subinventoryCode=" + subinventoryCode +
        ", transactionTypeId=" + transactionTypeId +
        ", transactionActionId=" + transactionActionId +
        ", transactionSourceTypeId=" + transactionSourceTypeId +
        ", transactionSourceId=" + transactionSourceId +
        ", transactionQuantity=" + transactionQuantity +
        ", transactionUom=" + transactionUom +
        ", transactionReference=" + transactionReference +
        ", transferOrganizationId=" + transferOrganizationId +
        ", transferSubinventory=" + transferSubinventory +
        ", owningOrganizationId=" + owningOrganizationId +
        ", transferTransactionId=" + transferTransactionId +
        ", ibpSourceType=" + ibpSourceType +
        ", ibpSourceId=" + ibpSourceId +
        ", ibpSourceNo=" + ibpSourceNo +
        ", sourceLineId=" + sourceLineId +
        ", rcvTransactionId=" + rcvTransactionId +
        ", createdBy=" + createdBy +
        ", creationDate=" + creationDate +
        ", createdDate=" + createdDate +
        ", lastModifiedDate=" + lastModifiedDate +
        "}";
    }
}
