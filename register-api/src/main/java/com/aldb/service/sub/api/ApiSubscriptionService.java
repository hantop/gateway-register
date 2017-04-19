/**
 * 
 */
package com.aldb.service.sub.api;

import com.aldb.service.sub.api.bean.ApiSubscription;

/**
 * @author Administrator
 *
 */
public interface ApiSubscriptionService {

    ApiSubscription queryApiSubscriptionByAppIdAndApiId(Long appSubscriptionId, Long apiInfoId);

}
