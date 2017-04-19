/**
 * 
 */
package com.aldb.service.regist.api;

import com.aldb.service.regist.api.bean.ApiInfoDto;

/**
 * @author Administrator
 *
 */
public interface ApiInfoService {

    ApiInfoDto queryApiInfoByIdAndVersion(String apiId, String apiVersion);

}
