package com.sports.life.entity;

import java.io.Serializable;
import java.util.Date;

public class Apply implements Serializable {
    private String id;

    private Integer number;

    private Integer price;

    private Date appEndTime;

    private Integer scope;

    private Date appTime;

    private Integer standby;

    private Integer purchaseLimitation;

    private String acId;

    private Date createTime;

    private String createId;

    private Date updateTime;

    private String updateId;

    private String code;

    private String name;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getAppEndTime() {
        return appEndTime;
    }

    public void setAppEndTime(Date appEndTime) {
        this.appEndTime = appEndTime;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public Integer getStandby() {
        return standby;
    }

    public void setStandby(Integer standby) {
        this.standby = standby;
    }

    public Integer getPurchaseLimitation() {
        return purchaseLimitation;
    }

    public void setPurchaseLimitation(Integer purchaseLimitation) {
        this.purchaseLimitation = purchaseLimitation;
    }

    public String getAcId() {
        return acId;
    }

    public void setAcId(String acId) {
        this.acId = acId == null ? null : acId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", price=").append(price);
        sb.append(", appEndTime=").append(appEndTime);
        sb.append(", scope=").append(scope);
        sb.append(", appTime=").append(appTime);
        sb.append(", standby=").append(standby);
        sb.append(", purchaseLimitation=").append(purchaseLimitation);
        sb.append(", acId=").append(acId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}