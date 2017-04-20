package com.aldb.service.regist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aldb.service.regist.dao.bean.ApiInfo;

public interface ApiInfoDao {
   // Long getApiInfoIdNextVal();

    ApiInfo getApiInfoById(Long oid);

    int insertApiInfo(ApiInfo record);

    int insertSelectiveApiInfo(ApiInfo record);

    int updateApiInfoById(ApiInfo record);

    int updateSelectiveApiInfoById(ApiInfo record);

    int deleteApiInfoById(Long oid);
    
    
    
   public  List<ApiInfo>  queryApiInfoList(@Param("start") int start, @Param("size") int size, @Param("pdName") String pdName);
    
    public int count(@Param("pdName") String pdName);
}