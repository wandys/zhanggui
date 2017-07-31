package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.SpecificationGroupDao;
import com.shuidi.zhanggui.service.dal.entity.SpecificationGroup;
import com.shuidi.zhanggui.service.dal.mappers.SpecificationGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("specificationGroupDao")
public class SpecificationGroupDaoImpl implements SpecificationGroupDao {

    @Autowired
    private SpecificationGroupMapper specificationGroupMapper;

    @Override
    public SpecificationGroup getById(Long id) {
        return specificationGroupMapper.getById(id);
    }

    @Override
    public List<SpecificationGroup> findList(Map params) {
        return specificationGroupMapper.findList(params);
    }

    @Override
    public int insert(SpecificationGroup specificationGroup) {
        return specificationGroupMapper.insert(specificationGroup);
    }

    @Override
    public int update(SpecificationGroup specificationGroup) {
        return specificationGroupMapper.update(specificationGroup);
    }
}
