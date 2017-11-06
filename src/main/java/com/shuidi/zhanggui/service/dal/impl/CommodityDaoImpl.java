package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CommodityDao;
import com.shuidi.zhanggui.service.dal.entity.Commodity;
import com.shuidi.zhanggui.service.dal.mappers.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("commodityDao")
public class CommodityDaoImpl implements CommodityDao {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public Commodity getById(Long id) {
        return commodityMapper.getById(id);
    }

    @Override
    public List<Commodity> findCommodityList(Map params) {
        return commodityMapper.findList(params);
    }

    @Override
    public int insertCommodity(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    @Override
    public int updateCommodity(Commodity commodity) {
        return commodityMapper.update(commodity);
    }
}
