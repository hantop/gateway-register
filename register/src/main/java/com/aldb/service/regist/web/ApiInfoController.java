/**
 * 
 */
package com.aldb.service.regist.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aldb.service.common.bean.Pagination;
import com.aldb.service.common.bean.PaginationParas;
import com.aldb.service.regist.api.ApiInfoService;
import com.aldb.service.regist.api.bean.ApiInfoDto;
import com.aldb.service.regist.api.bean.ApiSysInfoDto;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apiInfo")
public class ApiInfoController {

    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ApiInfoDto getApiSysInfoDtoById(Long id) {
        return apiInfoService.getInfoById(id);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String delApiInfoDtoById(Long id) {
        if (id != null) {
            apiInfoService.doDeleteApiInfo(id);
            return "ok";
        } else {
            return "没有传入需要删除的数据id";
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(ApiInfoDto dto) {
        if (dto != null && dto.getId() != null) {
            // 更新
            dto.setUpdatedAt(new Date());
            apiInfoService.doUpdateApiInfo(dto);
        } else if (dto != null && dto.getId() == null) {
            // 新增
            dto.setCreatedAt(new Date());
            dto.setUpdatedAt(new Date());
            dto.setCreatedBy("zhuzhong");
            dto.setUpdatedBy("zhuzhong");
            apiInfoService.doInsertApiInfo(dto);
        }
        return "ok";
    }
    
    
    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList() {
        return "apiinfo-list";
    }

    @Autowired
    private ApiInfoService apiInfoService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination<ApiInfoDto> list(@RequestBody Map map) {

        Integer limit = (Integer) map.get("limit");
        Integer offset = (Integer) map.get("offset");
        PaginationParas paras = new PaginationParas(limit, offset);
        // 进行查询

        List<ApiInfoDto> rows = apiInfoService.getApiInfoDtoList(paras);

        Pagination<ApiInfoDto> p = new Pagination<ApiInfoDto>();
        p.setRows(rows);
        p.setTotal(CollectionUtils.isEmpty(rows) ? 0 : rows.size());
        return p;
    }

/*    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public ApiInfoDto view(Long appId) throws UnsupportedEncodingException {

        if (appId == null) {
            appId = 1L;
        }
        ApiInfoDto apiInfoDto = apiInfoService.queryApiInfoDtoById(appId);
        return apiInfoDto;

    }*/

}
