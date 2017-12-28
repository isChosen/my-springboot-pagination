package com.liangchaoshun.dao;

import com.liangchaoshun.entity.GirlsBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GirlsDao {
	// 查询所有妹纸总数量
    Long queryAllGirlsCount();
    // 查询所有妹纸
    List<GirlsBean> queryAllGirls(Map<String, Object> param);
    // 查询某个妹纸
    List<GirlsBean> queryGirlsName(String name);

}
