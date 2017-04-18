/**
 * 
 */
package com.aldb.gateway.regist.api.bean;

import com.aldb.gateway.common.bean.BaseDto;

/**
 * @author Administrator
 *
 */
public class ApiMachineInfo extends BaseDto {

    private Long id;

    private String machIp;
    private String machPort;
    private Long apiSysInfoId;

    private Integer online;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachIp() {
        return machIp;
    }

    public void setMachIp(String machIp) {
        this.machIp = machIp;
    }

    public String getMachPort() {
        return machPort;
    }

    public void setMachPort(String machPort) {
        this.machPort = machPort;
    }

    public Long getApiSysInfoId() {
        return apiSysInfoId;
    }

    public void setApiSysInfoId(Long apiSysInfoId) {
        this.apiSysInfoId = apiSysInfoId;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

}
