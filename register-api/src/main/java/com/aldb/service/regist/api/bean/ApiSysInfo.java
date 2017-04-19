/**
 * 
 */
package com.aldb.service.regist.api.bean;

import com.aldb.service.common.bean.BaseDto;


/**
 * @author Administrator
 *
 */
public class ApiSysInfo extends BaseDto {

    private Long id;
    private String sysName;
    private String sysRemark;
    

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
        this.sysName = sysName;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }

  

}
