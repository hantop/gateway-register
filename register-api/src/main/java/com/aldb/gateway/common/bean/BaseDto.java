/**
 * 
 */
package com.aldb.gateway.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class BaseDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 705388010681072202L;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

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
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
