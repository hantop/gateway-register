package com.aldb.service.sub.dao;

import com.aldb.service.sub.dao.bean.AppInfo;

public interface AppInfoDao {
   // Long getAppInfoIdNextVal();

    AppInfo getAppInfoById(Long oid);

    int insertAppInfo(AppInfo record);

    int insertSelectiveAppInfo(AppInfo record);

    int updateAppInfoById(AppInfo record);

    int updateSelectiveAppInfoById(AppInfo record);

    int deleteAppInfoById(Long oid);
}