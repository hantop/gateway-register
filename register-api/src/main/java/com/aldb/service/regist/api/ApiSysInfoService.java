package com.aldb.service.regist.api;

import java.util.List;

import com.aldb.service.common.bean.PaginationParas;
import com.aldb.service.regist.api.bean.ApiSysInfoDto;

public interface ApiSysInfoService {

    ApiSysInfoDto getSysInfoById(Long id);
    
    public List<ApiSysInfoDto> getApiSysInfoDtoList(PaginationParas paginationParas);
    
    public Long doInsertSysInfo(ApiSysInfoDto record);
    
    public int doUpdateSysInfo(ApiSysInfoDto record);
    
    public int doDeleteSysInfo(Long id);
}
