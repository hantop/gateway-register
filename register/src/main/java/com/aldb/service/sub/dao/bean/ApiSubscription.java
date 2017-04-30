package com.aldb.service.sub.dao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * *table name is t_api_subscription 2017-04-19 11:22:39
 */
public class ApiSubscription implements Serializable{
    /**
     * pk
     */
    private Long oid;

    /**
     * app订阅系统id
     */
    private Long fAppSubscriptionId;

    /**
     * 订阅的apiid
     */
    private Long fApiInfoId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getfAppSubscriptionId() {
        return fAppSubscriptionId;
    }

    public void setfAppSubscriptionId(Long fAppSubscriptionId) {
        this.fAppSubscriptionId = fAppSubscriptionId;
    }

    public Long getfApiInfoId() {
        return fApiInfoId;
    }

    public void setfApiInfoId(Long fApiInfoId) {
        this.fApiInfoId = fApiInfoId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }
}