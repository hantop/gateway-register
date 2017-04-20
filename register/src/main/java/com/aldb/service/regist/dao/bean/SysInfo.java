package com.aldb.service.regist.dao.bean;

import java.util.Date;

/**
 * *table name is t_sys_info 2017-04-19 11:17:02
 */
public class SysInfo {
    /**
     * pk
     */
    private Long id;

    /**
     * 绯荤粺鍚嶅瓧
     */
    private String sysName;

    /**
     * 绯荤粺璇存槑
     */
    private String sysRemark;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createdAt;

    /**
     * 鏇存柊鏃堕棿
     */
    private Date updatedAt;

    /**
     * 鍒涘缓浜�
     */
    private String createdBy;

    /**
     * 鏇存柊浜�
     */
    private String updatedBy;

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark == null ? null : sysRemark.trim();
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