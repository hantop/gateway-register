/**
 * 
 */
package com.aldb.gateway.regist.api;

import java.util.List;

import com.aldb.gateway.regist.api.bean.ApiMachineInfo;

/**
 * @author Administrator
 *
 */
public interface ApiMachineInfoService {

    List<ApiMachineInfo> queryMachineInfosBySysId(Long sysInfoId);
}
