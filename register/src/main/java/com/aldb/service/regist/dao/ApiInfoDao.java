package com.aldb.service.regist.dao;

import com.aldb.service.regist.dao.bean.ApiInfo;

public interface ApiInfoDao {
    Long getApiInfoIdNextVal();

    ApiInfo getApiInfoById(Long oid);

    int insertApiInfo(ApiInfo record);

    int insertSelectiveApiInfo(ApiInfo record);

    int updateApiInfoById(ApiInfo record);

    int updateSelectiveApiInfoById(ApiInfo record);

    int deleteApiInfoById(Long oid);
}