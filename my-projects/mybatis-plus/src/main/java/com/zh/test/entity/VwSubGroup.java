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
@TableName("T_VW_SUB_GROUP")
public class VwSubGroup implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 虚拟仓替代组ID
     */
    @TableId(value = "VW_SUB_GROUP_ID", type = IdType.ASSIGN_ID)
    private String vwSubGroupId;

    /**
     * 虚拟仓替代组名称
     */
    @TableField("VW_SUB_GROUP_NAME")
    private String vwSubGroupName;

    /**
     * 虚拟仓替代组描述
     */
    @TableField("VW_SUB_GROUP_DESCRIPTION")
    private String vwSubGroupDescription;

    /**
     * 虚拟仓替代组编号
     */
    @TableField("VW_SUB_GROUP_NO")
    private String vwSubGroupNo;

    /**
     * 状态0停用，1启用
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


    public String getVwSubGroupId() {
        return vwSubGroupId;
    }

    public void setVwSubGroupId(String vwSubGroupId) {
        this.vwSubGroupId = vwSubGroupId;
    }

    public String getVwSubGroupName() {
        return vwSubGroupName;
    }

    public void setVwSubGroupName(String vwSubGroupName) {
        this.vwSubGroupName = vwSubGroupName;
    }

    public String getVwSubGroupDescription() {
        return vwSubGroupDescription;
    }

    public void setVwSubGroupDescription(String vwSubGroupDescription) {
        this.vwSubGroupDescription = vwSubGroupDescription;
    }

    public String getVwSubGroupNo() {
        return vwSubGroupNo;
    }

    public void setVwSubGroupNo(String vwSubGroupNo) {
        this.vwSubGroupNo = vwSubGroupNo;
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
        return "VwSubGroup{" +
        "vwSubGroupId=" + vwSubGroupId +
        ", vwSubGroupName=" + vwSubGroupName +
        ", vwSubGroupDescription=" + vwSubGroupDescription +
        ", vwSubGroupNo=" + vwSubGroupNo +
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
