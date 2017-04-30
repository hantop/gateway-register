package com.aldb.service.regist.dao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * *table name is t_machine_info 2017-04-19 11:17:02
 */
public class MachineInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3755807037171750839L;

	/**
     * pk
     */
    private Long oid;

    /**
     * 服务器ip
     */
    private String mIp;

    /**
     * 服务器端口
     */
    private Integer mPort;

    /**
     * 所属系统id
     */
    private Long fSysInfoId;

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

    /**
     * 是否在线，1在线0下线
     */
    private Integer isOnline;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getmIp() {
        return mIp;
    }

    public void setmIp(String mIp) {
        this.mIp = mIp == null ? null : mIp.trim();
    }

    public Integer getmPort() {
        return mPort;
    }

    public void setmPort(Integer mPort) {
        this.mPort = mPort;
    }

    public Long getfSysInfoId() {
        return fSysInfoId;
    }

    public void setfSysInfoId(Long fSysInfoId) {
        this.fSysInfoId = fSysInfoId;
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

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }
}