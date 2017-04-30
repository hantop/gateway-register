package com.aldb.service.regist.dao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * *table name is t_api_info 2017-04-19 11:17:02
 */
public class ApiInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6293394727575417717L;

	/**
     * pk
     */
    private Long id;

    /**
     * api的名字
     */
    private String apiName;

    /**
     * api的唯一标识
     */
    private String apiId;

    /**
     * api版本号
     */
    private String apiVersion;

    /**
     * 请求参数名
     */
    private String apiParasName;

    /**
     * 支持的请求方法,多个用英文逗号隔开
     */
    private String apiReqMethod;

    /**
     * 所属系统id
     */
    private Long fSysInfoId;

    /**
     * 请求路径,即对应的spring mvc requestmapping的value值
     */
    private String apiUrl;

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

    /**
     * 请求协议,http,https
     */
    private String apiProtocol;

  
    private String respFormat; // 响应格式
    private String respParams;// 响应参数
    
    
    private String host;//api服务器地址,用于分流
    
    
    public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getRespFormat() {
        return respFormat;
    }

    public void setRespFormat(String respFormat) {
        this.respFormat = respFormat;
    }

    public String getRespParams() {
        return respParams;
    }

    public void setRespParams(String respParams) {
        this.respParams = respParams;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId == null ? null : apiId.trim();
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion == null ? null : apiVersion.trim();
    }

    public String getApiParasName() {
        return apiParasName;
    }

    public void setApiParasName(String apiParasName) {
        this.apiParasName = apiParasName == null ? null : apiParasName.trim();
    }

    public String getApiReqMethod() {
        return apiReqMethod;
    }

    public void setApiReqMethod(String apiReqMethod) {
        this.apiReqMethod = apiReqMethod == null ? null : apiReqMethod.trim();
    }

    public Long getfSysInfoId() {
        return fSysInfoId;
    }

    public void setfSysInfoId(Long fSysInfoId) {
        this.fSysInfoId = fSysInfoId;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
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

    public String getApiProtocol() {
        return apiProtocol;
    }

    public void setApiProtocol(String apiProtocol) {
        this.apiProtocol = apiProtocol == null ? null : apiProtocol.trim();
    }
}