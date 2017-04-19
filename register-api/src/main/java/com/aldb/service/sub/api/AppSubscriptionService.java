/**
 * 
 */
package com.aldb.service.sub.api;

import com.aldb.service.sub.api.bean.AppSubscription;

/**
 * @author Administrator
 *
 */
public interface AppSubscriptionService {

    AppSubscription queryAppSubscriptionByIdAndToken(String appId, String appToken);

}
