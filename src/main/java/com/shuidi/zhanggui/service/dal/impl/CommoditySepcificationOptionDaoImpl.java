package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CommoditySepcificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommoditySepcificationOption;
import com.shuidi.zhanggui.service.dal.mappers.CommoditySepcificationOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("commoditySepcificationOptionDao")
public class CommoditySepcificationOptionDaoImpl implements CommoditySepcificationOptionDao {

    @Autowired
    private CommoditySepcificationOptionMapper commoditySepcificationOptionMapper;

    @Override
    public CommoditySepcificationOption getById(Long id) {
        return commoditySepcificationOptionMapper.getById(id);
    }

    @Override
    public List<CommoditySepcificationOption> findList(Map params) {
        return commoditySepcificationOptionMapper.findList(params);
    }

    @Override
    public int insertCommonditySepcificationOption(CommoditySepcificationOption commoditySepcificationOption) {
        return commoditySepcificationOptionMapper.insert(commoditySepcificationOption);
    }

    @Override
    public int updateCommonditySepcificationOption(CommoditySepcificationOption commoditySepcificationOption) {
        return commoditySepcificationOptionMapper.update(commoditySepcificationOption);
    }
}
