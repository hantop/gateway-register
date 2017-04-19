/**
 * 
 */
package com.aldb.service.sub.api;

import com.aldb.service.sub.api.bean.AppInfoDto;

/**
 * @author Administrator
 *
 */
public interface AppInfoService {

    AppInfoDto queryAppSubscriptionByIdAndToken(String appId, String appToken);

}
