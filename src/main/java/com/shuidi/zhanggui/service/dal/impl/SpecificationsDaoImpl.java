package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.commons.utils.CheckUtils;
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
        CheckUtils.notNull(id);
        return specificationsMapper.getById(id);
    }

    @Override
    public List<Specifications> findList(Map params) {
        return specificationsMapper.findSpecificationsList(params);
    }

    @Override
    public Long insertSpecifications(Specifications specifications) {
        CheckUtils.notNull(specifications);
        specificationsMapper.insertSpecifications(specifications);
        return specifications.getId();
    }

    @Override
    public int updateSpecifications(Specifications specifications) {
        CheckUtils.notNull(specifications);
        int size = specificationsMapper.updateSpecifications(specifications);
        CheckUtils.greaterThenZero(size);
        return size;
    }
}
