package com.liangchaoshun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liangchaoshun.entity.GirlsBean;
import com.liangchaoshun.service.GirlsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * Author: Administrator
 * Date: 2017/12/2
 * Description
 */

@RestController
@RequestMapping("/girls")
public class GirlsController {

    @Resource
    private GirlsService girlsService;
    // all girls
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.POST)
    public JSONObject allGirls(@RequestBody(required=false) String request) {
    	JSONObject result = new JSONObject();
    	JSONObject json = JSON.parseObject(request);
    	int currPage = json.getString("currPage") == null ? 1: json.getIntValue("currPage");
    	int pageSize = json.getString("pageSize") == null ? 10: json.getIntValue("pageSize");
    	String girlsName = json.getString("name");
    	int startIndex = (currPage - 1) * pageSize;
    	Long allRecords = girlsService.getAllGirlsCount();
    	Long totalPage = allRecords%pageSize == 0 ? allRecords/pageSize : allRecords%pageSize + 1;
    	
    	result.put("allRecords", allRecords);
    	result.put("totalPage", totalPage);
    	
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("startIndex", startIndex);
    	paraMap.put("pageSize", pageSize);
    	paraMap.put("girlsName", girlsName);
        List<GirlsBean> girlsBeans = girlsService.getAllGirls(paraMap);
        result.put("girlsList", girlsBeans);
    	return result;
    }
    // part of girls due to the parameter
    @RequestMapping(value="/queryGirlsByName", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public List<GirlsBean> someGirls(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        String girlsName = json.getString("name");
        return girlsService.getGirlsName(girlsName);
    }
}
