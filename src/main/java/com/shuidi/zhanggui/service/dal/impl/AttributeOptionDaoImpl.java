package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.AttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.AttributeOption;
import com.shuidi.zhanggui.service.dal.mappers.AttributeOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("attributeOptionDao")
public class AttributeOptionDaoImpl implements AttributeOptionDao {

    @Autowired
    private AttributeOptionMapper attributeOptionMapper;

    @Override
    public AttributeOption getById(Long id) {
        return attributeOptionMapper.getById(id);
    }

    @Override
    public List<AttributeOption> findList(Map params) {
        return attributeOptionMapper.findList(params);
    }

    @Override
    public int insert(AttributeOption attributeOption) {
        return attributeOptionMapper.insert(attributeOption);
    }

    @Override
    public int update(AttributeOption attributeOption) {
        return attributeOptionMapper.update(attributeOption);
    }
}
