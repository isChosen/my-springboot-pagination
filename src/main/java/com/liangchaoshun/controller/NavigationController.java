package com.liangchaoshun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * Author: Administrator
 * Date: 2017/12/17
 * Description:
 */

@Controller
public class NavigationController {

    // 主页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
