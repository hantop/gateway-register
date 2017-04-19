/**
 * 
 */
package com.aldb.service.regist.api;

import java.util.List;

import com.aldb.service.regist.api.bean.ApiMachineInfo;

/**
 * @author Administrator
 *
 */
public interface ApiMachineInfoService {

    List<ApiMachineInfo> queryMachineInfosBySysId(Long sysInfoId);
}
