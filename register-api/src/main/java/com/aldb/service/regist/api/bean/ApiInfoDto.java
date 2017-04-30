/**
 * 
 */
package com.aldb.service.regist.api.bean;

import com.aldb.service.common.bean.BaseDto;

/**
 * @author Administrator
 *
 */
public class ApiInfoDto extends BaseDto {

    private Long id;
    private String apiName;
    private String apiId;
    private String apiVersion;
    private String apiParasName;
    private String apiReqMethod;
    private Long fSysInfoId; // 让属系统

    private String apiUrl;

    private Integer isOnline;// 是否在线
    private String apiProtocol;// 支持协议

    private String respFormat; // 响应格式
    private String respParams;// 响应参数
    
    private String host;
    

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiParasName() {
        return apiParasName;
    }

    public void setApiParasName(String apiParasName) {
        this.apiParasName = apiParasName;
    }

    public String getApiReqMethod() {
        return apiReqMethod;
    }

    public void setApiReqMethod(String apiReqMethod) {
        this.apiReqMethod = apiReqMethod;
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
        this.apiUrl = apiUrl;
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
        this.apiProtocol = apiProtocol;
    }

}
