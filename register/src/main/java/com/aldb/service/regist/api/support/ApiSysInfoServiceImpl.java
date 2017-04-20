/**
 * 
 */
package com.aldb.service.regist.api.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aldb.service.common.bean.PaginationParas;
import com.aldb.service.regist.api.ApiSysInfoService;
import com.aldb.service.regist.api.bean.ApiSysInfoDto;
import com.aldb.service.regist.dao.SysInfoDao;
import com.aldb.service.regist.dao.bean.SysInfo;

/**
 * @author Administrator
 *
 */
@Service
public class ApiSysInfoServiceImpl implements ApiSysInfoService {

    @Autowired
    private SysInfoDao sysInfoDao;

    @Override
    public Long doInsertSysInfo(ApiSysInfoDto record) {

        SysInfo s = new SysInfo();
        BeanUtils.copyProperties(record, s);
        sysInfoDao.insertSysInfo(s);
        return s.getId();
    }

    /**
     * 
     */
    public ApiSysInfoDto getSysInfoById(Long id) {
        SysInfo sys = sysInfoDao.getSysInfoById(id);
        ApiSysInfoDto dto = new ApiSysInfoDto();
        BeanUtils.copyProperties(sys, dto);
        return dto;
    }

    @Override
    public List<ApiSysInfoDto> queryApiSysInfoDtoList(PaginationParas paginationParas) {
        List<SysInfo> sysInfoList = sysInfoDao
                .querySysInfoList(paginationParas.getLimit(), paginationParas.getOffset());
        List<ApiSysInfoDto> result = new ArrayList<ApiSysInfoDto>();
        if (!CollectionUtils.isEmpty(sysInfoList)) {
            for (SysInfo f : sysInfoList) {
                ApiSysInfoDto s = new ApiSysInfoDto();
                BeanUtils.copyProperties(f, s);
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public int doUpdateSysInfo(ApiSysInfoDto record) {
        SysInfo s = new SysInfo();
        BeanUtils.copyProperties(record, s);
        return sysInfoDao.updateSysInfoById(s);
    }

    /* (non-Javadoc)
     * @see com.aldb.service.regist.api.ApiSysInfoService#doDeleteSysInfo(java.lang.Long)
     */
    @Override
    public int doDeleteSysInfo(Long id) {
        
        return sysInfoDao.deleteSysInfoById(id);
    }

}
