package com.aldb.service.regist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aldb.service.regist.dao.bean.SysInfo;

public interface SysInfoDao {
  //  Long getSysInfoIdNextVal();

    SysInfo getSysInfoById(Long oid);

    int insertSysInfo(SysInfo record);

    int insertSelectiveSysInfo(SysInfo record);

    int updateSysInfoById(SysInfo record);

    int updateSelectiveSysInfoById(SysInfo record);

    int deleteSysInfoById(Long oid);
    
    List<SysInfo> querySysInfoList(@Param("size") int size,@Param("start") int start);
    
}