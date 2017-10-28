package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CommodityAttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommodityAttributeOption;
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
    public CommodityAttributeOption getById(Long id) {
        return commodityAttributeOptionMapper.getById(id);
    }

    @Override
    public List<CommodityAttributeOption> findList(Map params) {
        return commodityAttributeOptionMapper.findList(params);
    }

    @Override
    public int insertCommmodityAttributeOption(CommodityAttributeOption commmodityAttributeOption) {
        return commodityAttributeOptionMapper.insertCommmodityAttributeOption(commmodityAttributeOption);
    }

    @Override
    public int updateCommmodityAttributeOption(CommodityAttributeOption commmodityAttributeOption) {
        return commodityAttributeOptionMapper.updateCommmodityAttributeOption(commmodityAttributeOption);
    }
}
