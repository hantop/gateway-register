/**
 * 
 */
package com.aldb.service.regist.api;

import java.util.List;

import com.aldb.service.regist.api.bean.ApiMachineInfoDto;

/**
 * @author Administrator
 *
 */
public interface ApiMachineInfoService {

    List<ApiMachineInfoDto> queryMachineInfosBySysId(Long sysInfoId);
}
