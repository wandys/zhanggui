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
    public List<Attribute> findAttributeList(Map params) {
        return attributeMapper.findAttributeList(params);
    }

    @Override
    public int insertAttribute(Attribute attribute) {
        return attributeMapper.insertAttribute(attribute);
    }

    @Override
    public int updateAttribute(Attribute attribute) {
        return attributeMapper.updateAttribute(attribute);
    }
}
