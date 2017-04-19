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
    private Long apiSysInfoId; // 所属系统

    private String apiUrl;

    private Integer online;// 是否在线
    private String apiProtocol;// 所用协议http,https

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

    public Long getApiSysInfoId() {
        return apiSysInfoId;
    }

    public void setApiSysInfoId(Long apiSysInfoId) {
        this.apiSysInfoId = apiSysInfoId;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getApiProtocol() {
        return apiProtocol;
    }

    public void setApiProtocol(String apiProtocol) {
        this.apiProtocol = apiProtocol;
    }

}
