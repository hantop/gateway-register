/**
 * 
 */
package com.aldb.service.sub.api.bean;

/**
 * @author Administrator
 *
 */
public class ApiSubscriptionDto {

    private Long id;
    private Long appSubscriptionId;
    private Long apiInfoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppSubscriptionId() {
        return appSubscriptionId;
    }

    public void setAppSubscriptionId(Long appSubscriptionId) {
        this.appSubscriptionId = appSubscriptionId;
    }

    public Long getApiInfoId() {
        return apiInfoId;
    }

    public void setApiInfoId(Long apiInfoId) {
        this.apiInfoId = apiInfoId;
    }

}
