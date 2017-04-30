/**
 * 
 */
package com.aldb.service.regist.web;

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
import com.aldb.service.regist.api.ApiSysInfoService;
import com.aldb.service.regist.api.bean.ApiSysInfoDto;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apiSysInfo")
public class ApiSysInfoController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ApiSysInfoDto getApiSysInfoDtoById(Long id) {
        return apiSysInfoService.getSysInfoById(id);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String delApiSysInfoDtoById(Long id) {
        if (id != null) {
            apiSysInfoService.doDeleteSysInfo(id);
            return "ok";
        } else {
            return "没有传入需要删除的数据id";
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(ApiSysInfoDto dto) {
        if (dto != null && dto.getId() != null) {
            // 更新
            dto.setUpdatedAt(new Date());
            apiSysInfoService.doUpdateSysInfo(dto);
        } else if (dto != null && dto.getId() == null) {
            // 新增
            dto.setCreatedAt(new Date());
            dto.setUpdatedAt(new Date());
            dto.setCreatedBy("zhuzhong");
            dto.setUpdatedBy("zhuzhong");
            apiSysInfoService.doInsertSysInfo(dto);
        }
        return "ok";
    }

    @RequestMapping("/toList")
    public String toList() {
        return "apisysinfo-list";
    }

    @Autowired
    private ApiSysInfoService apiSysInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public Pagination<ApiSysInfoDto> list(@RequestBody Map map) {
        Integer limit = (Integer) map.get("limit");
        Integer offset = (Integer) map.get("offset");
        PaginationParas paras = new PaginationParas(limit, offset);
        // 进行查询

        List<ApiSysInfoDto> rows = apiSysInfoService.getApiSysInfoDtoList(paras);
        Pagination<ApiSysInfoDto> p = new Pagination<>();
        p.setRows(rows);
        p.setTotal(CollectionUtils.isEmpty(rows) ? 0 : rows.size());
        return p;

    }

    @RequestMapping("/queryAllSys")
    @ResponseBody
    public  List<ApiSysInfoDto> queryAllSys(){
    	 List<ApiSysInfoDto> rows = apiSysInfoService.getApiSysInfoDtoList(null);
    	 return rows;
    }

}
