/**
 * 
 */
package com.aldb.service.regist.api;

import com.aldb.service.regist.api.bean.ApiInfo;

/**
 * @author Administrator
 *
 */
public interface ApiInfoService {

    ApiInfo queryApiInfoByIdAndVersion(String apiId, String apiVersion);

}
