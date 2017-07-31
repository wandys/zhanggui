package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.AttributeDao;
import com.shuidi.zhanggui.service.dal.entity.Attribute;
import com.shuidi.zhanggui.service.dal.mappers.AttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("attributeDao")
public class AttributeDaoImpl implements AttributeDao {

    @Autowired
    private AttributeMapper attributeMapper;


    @Override
    public Attribute getById(Long id) {
        return attributeMapper.getById(id);
    }

    @Override
    public List<Attribute> findList(Map params) {
        return attributeMapper.findList(params);
    }

    @Override
    public int insert(Attribute attribute) {
        return attributeMapper.insert(attribute);
    }

    @Override
    public int update(Attribute attribute) {
        return attributeMapper.update(attribute);
    }
}
