package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.SpecificationsDao;
import com.shuidi.zhanggui.service.dal.entity.Specifications;
import com.shuidi.zhanggui.service.dal.mappers.SpecificationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("specificationsDao")
public class SpecificationsDaoImpl implements SpecificationsDao {

    @Autowired
    private SpecificationsMapper specificationsMapper;

    @Override
    public Specifications getById(Long id) {
        return specificationsMapper.getById(id);
    }

    @Override
    public List<Specifications> findList(Map params) {
        return specificationsMapper.findList(params);
    }

    @Override
    public int insert(Specifications specifications) {
        return specificationsMapper.insert(specifications);
    }

    @Override
    public int update(Specifications specifications) {
        return specificationsMapper.update(specifications);
    }
}
