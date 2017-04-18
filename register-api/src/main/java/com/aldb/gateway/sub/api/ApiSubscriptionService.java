/**
 * 
 */
package com.aldb.gateway.sub.api;

import com.aldb.gateway.sub.api.bean.ApiSubscription;

/**
 * @author Administrator
 *
 */
public interface ApiSubscriptionService {

    ApiSubscription queryApiSubscriptionByAppIdAndApiId(Long appSubscriptionId, Long apiInfoId);

}
