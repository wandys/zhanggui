package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CommodityAttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommmodityAttributeOption;
import com.shuidi.zhanggui.service.dal.mappers.CommodityAttributeOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("commodityAttributeOptionDao")
public class CommodityAttributeOptionDaoImpl implements CommodityAttributeOptionDao {

    @Autowired
    private CommodityAttributeOptionMapper commodityAttributeOptionMapper;

    @Override
    public CommmodityAttributeOption getById(Long id) {
        return commodityAttributeOptionMapper.getById(id);
    }

    @Override
    public List<CommmodityAttributeOption> findList(Map params) {
        return commodityAttributeOptionMapper.findList(params);
    }

    @Override
    public int insert(CommmodityAttributeOption commmodityAttributeOption) {
        return commodityAttributeOptionMapper.insert(commmodityAttributeOption);
    }

    @Override
    public int update(CommmodityAttributeOption commmodityAttributeOption) {
        return commodityAttributeOptionMapper.update(commmodityAttributeOption);
    }
}
