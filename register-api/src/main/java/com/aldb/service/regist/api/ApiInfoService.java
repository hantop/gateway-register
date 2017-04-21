/**
 * 
 */
package com.aldb.service.regist.api;

import java.util.List;

import com.aldb.service.common.bean.PaginationParas;
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
    public List<ApiInfoDto> getApiInfoDtoList(PaginationParas paginationParas);

    ApiInfoDto queryApiInfoDtoById(Long id);

    ApiInfoDto getInfoById(Long id);

    void doDeleteApiInfo(Long id);

    void doUpdateApiInfo(ApiInfoDto dto);

    void doInsertApiInfo(ApiInfoDto dto);
}
