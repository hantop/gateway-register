/**
 * 
 */
package com.aldb.service.sub.api;

import com.aldb.service.sub.api.bean.ApiSubscriptionDto;

/**
 * @author Administrator
 *
 */
public interface ApiSubscriptionService {

    ApiSubscriptionDto queryApiSubscriptionByAppIdAndApiId(Long appSubscriptionId, Long apiInfoId);

}
