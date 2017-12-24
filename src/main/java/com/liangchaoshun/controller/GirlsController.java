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
import java.util.List;

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
    @RequestMapping(value="/queryAllGirls", method = RequestMethod.GET)
    public List<GirlsBean> getNames() {
        return girlsService.getAllGirls();
    }
    // part of girls due to the parameter
    @RequestMapping(value="/queryGirlsByName", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public List<GirlsBean> getNames(@RequestBody String request) {
        JSONObject json = JSON.parseObject(request);
        String girlsName = json.getString("name");
        return girlsService.getGirlsName(girlsName);
    }
}
