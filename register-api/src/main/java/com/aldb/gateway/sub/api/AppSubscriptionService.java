/**
 * 
 */
package com.aldb.gateway.sub.api;

import com.aldb.gateway.sub.api.bean.AppSubscription;

/**
 * @author Administrator
 *
 */
public interface AppSubscriptionService {

    AppSubscription queryAppSubscriptionByIdAndToken(String appId, String appToken);

}
