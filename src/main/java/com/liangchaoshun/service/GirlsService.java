package com.liangchaoshun.service;

import com.liangchaoshun.dao.GirlsDao;
import com.liangchaoshun.entity.GirlsBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public List<GirlsBean> getAllGirls(Map<String, Object> param) {
        return girlsMapper.queryAllGirls(param);
    }
    // part of girls
    public List<GirlsBean> getGirlsName(String name) {
        return girlsMapper.queryGirlsName(name);
    }
	public Long getAllGirlsCount() {
		return girlsMapper.queryAllGirlsCount(); 
	}
}
