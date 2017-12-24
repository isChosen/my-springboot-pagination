package com.liangchaoshun.service;

import com.liangchaoshun.dao.GirlsDao;
import com.liangchaoshun.entity.GirlsBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: Administrator
 * Date: 2017/12/3
 * Description
 */

@Service
public class GirlsService {
    @Resource
    private GirlsDao girlsMapper;

    // all girls
    public List<GirlsBean> getAllGirls() {
        return girlsMapper.getAllGirls();
    }
    // part of girls
    public List<GirlsBean> getGirlsName(String name) {
        return girlsMapper.getGirlsName(name);
    }
}
