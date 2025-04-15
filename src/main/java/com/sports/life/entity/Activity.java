package com.sports.life.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Activity implements Serializable {
    private String id;

    private String acUrl;

    private String acTitle;

    private String acContent;

    private Integer acStatus;

    private String acAddress;

    private Date acStartTime;

    private Date acEndTime;

    private BigInteger acType;

    private String acSafe;

    private Integer acScope;

    private String acQuestionnaire;

    private Integer acRefund;

    private String acCategory;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private String acCode;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAcUrl() {
        return acUrl;
    }

    public void setAcUrl(String acUrl) {
        this.acUrl = acUrl == null ? null : acUrl.trim();
    }

    public String getAcTitle() {
        return acTitle;
    }

    public void setAcTitle(String acTitle) {
        this.acTitle = acTitle == null ? null : acTitle.trim();
    }

    public String getAcContent() {
        return acContent;
    }

    public void setAcContent(String acContent) {
        this.acContent = acContent == null ? null : acContent.trim();
    }

    public Integer getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(Integer acStatus) {
        this.acStatus = acStatus;
    }

    public String getAcAddress() {
        return acAddress;
    }

    public void setAcAddress(String acAddress) {
        this.acAddress = acAddress == null ? null : acAddress.trim();
    }

    public Date getAcStartTime() {
        return acStartTime;
    }

    public void setAcStartTime(Date acStartTime) {
        this.acStartTime = acStartTime;
    }

    public Date getAcEndTime() {
        return acEndTime;
    }

    public void setAcEndTime(Date acEndTime) {
        this.acEndTime = acEndTime;
    }

    public BigInteger getAcType() {
        return acType;
    }

    public void setAcType(BigInteger acType) {
        this.acType = acType;
    }

    public String getAcSafe() {
        return acSafe;
    }

    public void setAcSafe(String acSafe) {
        this.acSafe = acSafe == null ? null : acSafe.trim();
    }

    public Integer getAcScope() {
        return acScope;
    }

    public void setAcScope(Integer acScope) {
        this.acScope = acScope;
    }

    public String getAcQuestionnaire() {
        return acQuestionnaire;
    }

    public void setAcQuestionnaire(String acQuestionnaire) {
        this.acQuestionnaire = acQuestionnaire == null ? null : acQuestionnaire.trim();
    }

    public Integer getAcRefund() {
        return acRefund;
    }

    public void setAcRefund(Integer acRefund) {
        this.acRefund = acRefund;
    }

    public String getAcCategory() {
        return acCategory;
    }

    public void setAcCategory(String acCategory) {
        this.acCategory = acCategory == null ? null : acCategory.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode == null ? null : acCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", acUrl=").append(acUrl);
        sb.append(", acTitle=").append(acTitle);
        sb.append(", acContent=").append(acContent);
        sb.append(", acStatus=").append(acStatus);
        sb.append(", acAddress=").append(acAddress);
        sb.append(", acStartTime=").append(acStartTime);
        sb.append(", acEndTime=").append(acEndTime);
        sb.append(", acType=").append(acType);
        sb.append(", acSafe=").append(acSafe);
        sb.append(", acScope=").append(acScope);
        sb.append(", acQuestionnaire=").append(acQuestionnaire);
        sb.append(", acRefund=").append(acRefund);
        sb.append(", acCategory=").append(acCategory);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateId=").append(updateId);
        sb.append(", acCode=").append(acCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}