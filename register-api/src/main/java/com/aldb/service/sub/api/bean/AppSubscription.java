/**
 * 
 */
package com.aldb.service.sub.api.bean;

import com.aldb.service.common.bean.BaseDto;

/**
 * @author Administrator
 *
 */
public class AppSubscription extends BaseDto {

    private Long id;
    private Long appName;
    private String appRemark;
    private String apiId;
    private String appToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppName() {
        return appName;
    }

    public void setAppName(Long appName) {
        this.appName = appName;
    }

    public String getAppRemark() {
        return appRemark;
    }

    public void setAppRemark(String appRemark) {
        this.appRemark = appRemark;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

}
