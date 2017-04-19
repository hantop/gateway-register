package com.aldb.service.sub.dao;

import com.aldb.service.sub.dao.bean.ApiSubscription;

public interface ApiSubscriptionDao {
    //Long getApiSubscriptionIdNextVal();

    ApiSubscription getApiSubscriptionById(Long oid);

    int insertApiSubscription(ApiSubscription record);

    int insertSelectiveApiSubscription(ApiSubscription record);

    int updateApiSubscriptionById(ApiSubscription record);

    int updateSelectiveApiSubscriptionById(ApiSubscription record);

    int deleteApiSubscriptionById(Long oid);
}