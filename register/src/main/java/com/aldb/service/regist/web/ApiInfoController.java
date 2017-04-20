/**
 * 
 */
package com.aldb.service.regist.web;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aldb.service.common.bean.Page;
import com.aldb.service.common.bean.PageBean;
import com.aldb.service.regist.api.ApiInfoService;
import com.aldb.service.regist.api.bean.ApiInfoDto;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apiInfo")
public class ApiInfoController {

    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList() {
        return "apiinfo-list";
    }

    @Autowired
    private ApiInfoService apiInfoService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public PageBean<ApiInfoDto> list(@RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "length", defaultValue = "10") int pageSize,
            @RequestParam(value = "pbName", required = false) String pbName, Model model)
            throws UnsupportedEncodingException {

        Page<ApiInfoDto> result = apiInfoService.getBannerPage(start, pageSize, pbName);

        return new PageBean<ApiInfoDto>(result);
        // return null;
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public ApiInfoDto view(Long appId) throws UnsupportedEncodingException {

        if (appId == null) {
            appId = 1L;
        }
        ApiInfoDto apiInfoDto = apiInfoService.queryApiInfoDtoById(appId);
        return apiInfoDto;

    }

   
}
