package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CommoditySepcificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommonditySepcificationOption;
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
    public CommonditySepcificationOption getById(Long id) {
        return commoditySepcificationOptionMapper.getById(id);
    }

    @Override
    public List<CommonditySepcificationOption> findList(Map params) {
        return commoditySepcificationOptionMapper.findList(params);
    }

    @Override
    public int insertCommonditySepcificationOption(CommonditySepcificationOption commonditySepcificationOption) {
        return commoditySepcificationOptionMapper.insertCommonditySepcificationOption(commonditySepcificationOption);
    }

    @Override
    public int updateCommonditySepcificationOption(CommonditySepcificationOption commonditySepcificationOption) {
        return commoditySepcificationOptionMapper.updateCommonditySepcificationOption(commonditySepcificationOption);
    }
}
