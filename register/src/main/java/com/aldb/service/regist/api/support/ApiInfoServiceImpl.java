/**
 * 
 */
package com.aldb.service.regist.api.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aldb.service.common.bean.PaginationParas;
import com.aldb.service.regist.api.ApiInfoService;
import com.aldb.service.regist.api.bean.ApiInfoDto;
import com.aldb.service.regist.dao.ApiInfoDao;
import com.aldb.service.regist.dao.bean.ApiInfo;

/**
 * @author Administrator
 * 
 */
@Service
public class ApiInfoServiceImpl implements ApiInfoService {

	private static Log logger = LogFactory.getLog(ApiInfoServiceImpl.class);

	/**
     * 
     */
	public ApiInfoDto queryApiDtoByIdAndVersion(String apiId, String apiVersion) {

		return null;
	}

	@Autowired
	private ApiInfoDao apiInfoDao;

	/*
	 * @Override public Page<ApiInfoDto> getBannerPage(int start, int pageSize,
	 * String loanAppName) {
	 * 
	 * List<ApiInfo> list = apiInfoDao.queryApiInfoList(start, pageSize,
	 * loanAppName); List<ApiInfoDto> infoDtoList = new ArrayList<ApiInfoDto>();
	 * if (!CollectionUtils.isEmpty(list)) { for (ApiInfo apiInfo : list) {
	 * ApiInfoDto dto = new ApiInfoDto(); BeanUtils.copyProperties(apiInfo,
	 * dto); infoDtoList.add(dto); } } Page<ApiInfoDto> page = new
	 * Page<ApiInfoDto>(apiInfoDao.count(loanAppName), infoDtoList.size() /
	 * pageSize + 1, start, pageSize, infoDtoList);
	 * 
	 * return page; }
	 */

/*	@Override
	public ApiInfoDto queryApiInfoDtoById(Long id) {
		ApiInfo apiInfo = apiInfoDao.getApiInfoById(id);
		ApiInfoDto dto = new ApiInfoDto();
		BeanUtils.copyProperties(apiInfo, dto);
		return dto;
	}*/

	@Override
	public List<ApiInfoDto> getApiInfoDtoList(PaginationParas paginationParas) {
		List<ApiInfo> list = apiInfoDao.queryApiInfoList(
				paginationParas.getLimit(), paginationParas.getOffset(), null);
		List<ApiInfoDto> infoDtoList = new ArrayList<ApiInfoDto>();
		if (!CollectionUtils.isEmpty(list)) {
			for (ApiInfo apiInfo : list) {
				ApiInfoDto dto = new ApiInfoDto();
				BeanUtils.copyProperties(apiInfo, dto);
				infoDtoList.add(dto);
			}
		}
		return infoDtoList;
	}

	@Override
	public ApiInfoDto getInfoById(Long id) {
		ApiInfo info = apiInfoDao.getApiInfoById(id);
		ApiInfoDto dto = new ApiInfoDto();
		BeanUtils.copyProperties(info, dto);
		return dto;
	}

	@Override
	public void doDeleteApiInfo(Long id) {
		apiInfoDao.deleteApiInfoById(id);

	}

	@Override
	public void doUpdateApiInfo(ApiInfoDto dto) {

		ApiInfo info = new ApiInfo();
		BeanUtils.copyProperties(dto, info);
		apiInfoDao.updateApiInfoById(info);

	}

	@Override
	public void doInsertApiInfo(ApiInfoDto dto) {

		ApiInfo info = new ApiInfo();
		BeanUtils.copyProperties(dto, info);
		apiInfoDao.insertApiInfo(info);
		dto.setId(info.getId());// id传到前面去

	}

}
