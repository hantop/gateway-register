/**
 * 
 */
package com.aldb.gateway.regist.api;

import com.aldb.gateway.regist.api.bean.ApiInfo;

/**
 * @author Administrator
 *
 */
public interface ApiInfoService {

    ApiInfo queryApiInfoByIdAndVersion(String apiId, String apiVersion);

}
