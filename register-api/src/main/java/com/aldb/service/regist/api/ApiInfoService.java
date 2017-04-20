/**
 * 
 */
package com.aldb.service.regist.api;

import com.aldb.service.common.bean.Page;
import com.aldb.service.regist.api.bean.ApiInfoDto;

/**
 * @author Administrator
 *
 */
public interface ApiInfoService {

    ApiInfoDto queryApiDtoByIdAndVersion(String apiId, String apiVersion);

    /**
     * ∑÷“≥≤È—Øbanner
     * 
     * @param start
     * @param pageSize
     * @param loanAppName
     * @return
     */
    public Page<ApiInfoDto> getBannerPage(int start, int pageSize, String loanAppName);

    ApiInfoDto queryApiInfoDtoById(Long id);
}
