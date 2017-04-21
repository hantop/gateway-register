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

    /*
     * private static class VO { private int id, liushuid, price, mobilephone,
     * receivetime, tradetype, bill_credit, goodroadid, smsContent, orderid,
     * goodsName, inneridname, xmlstr; private String changestatus, sendstatus;
     * 
     * public int getId() { return id; }
     * 
     * public void setId(int id) { this.id = id; }
     * 
     * public int getLiushuid() { return liushuid; }
     * 
     * public void setLiushuid(int liushuid) { this.liushuid = liushuid; }
     * 
     * public int getPrice() { return price; }
     * 
     * public void setPrice(int price) { this.price = price; }
     * 
     * public int getMobilephone() { return mobilephone; }
     * 
     * public void setMobilephone(int mobilephone) { this.mobilephone =
     * mobilephone; }
     * 
     * public int getReceivetime() { return receivetime; }
     * 
     * public void setReceivetime(int receivetime) { this.receivetime =
     * receivetime; }
     * 
     * public int getTradetype() { return tradetype; }
     * 
     * public void setTradetype(int tradetype) { this.tradetype = tradetype; }
     * 
     * public int getBill_credit() { return bill_credit; }
     * 
     * public void setBill_credit(int bill_credit) { this.bill_credit =
     * bill_credit; }
     * 
     * public int getGoodroadid() { return goodroadid; }
     * 
     * public void setGoodroadid(int goodroadid) { this.goodroadid = goodroadid;
     * }
     * 
     * public int getSmsContent() { return smsContent; }
     * 
     * public void setSmsContent(int smsContent) { this.smsContent = smsContent;
     * }
     * 
     * public int getOrderid() { return orderid; }
     * 
     * public void setOrderid(int orderid) { this.orderid = orderid; }
     * 
     * public int getGoodsName() { return goodsName; }
     * 
     * public void setGoodsName(int goodsName) { this.goodsName = goodsName; }
     * 
     * public int getInneridname() { return inneridname; }
     * 
     * public void setInneridname(int inneridname) { this.inneridname =
     * inneridname; }
     * 
     * public int getXmlstr() { return xmlstr; }
     * 
     * public void setXmlstr(int xmlstr) { this.xmlstr = xmlstr; }
     * 
     * public String getChangestatus() { return changestatus; }
     * 
     * public void setChangestatus(String changestatus) { this.changestatus =
     * changestatus; }
     * 
     * public String getSendstatus() { return sendstatus; }
     * 
     * public void setSendstatus(String sendstatus) { this.sendstatus =
     * sendstatus; }
     * 
     * }
     */

}
