package com.aldb.service.sub.dao;

import com.aldb.service.sub.dao.bean.AppInfo;

public interface AppInfoDao {
    Long getAppInfoIdNextVal();

    int insertAppInfo(AppInfo record);

    int insertSelectiveAppInfo(AppInfo record);
}