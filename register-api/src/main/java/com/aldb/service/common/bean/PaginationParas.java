/**
 * 
 */
package com.aldb.service.common.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class PaginationParas implements Serializable {

    private final Integer limit;
    private final Integer offset;

    public PaginationParas(Integer limit, Integer offset) {
        super();
        this.limit = limit;
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

}
