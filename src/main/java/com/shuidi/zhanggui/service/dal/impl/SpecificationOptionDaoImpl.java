package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.commons.utils.CheckUtils;
import com.shuidi.zhanggui.service.dal.SpecificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.SpecificationOption;
import com.shuidi.zhanggui.service.dal.mappers.SpecificationOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("specificationOptionDao")
public class SpecificationOptionDaoImpl implements SpecificationOptionDao {

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    @Override
    public SpecificationOption getById(Long id) {
        CheckUtils.notNull(id);
        return specificationOptionMapper.getById(id);
    }

    @Override
    public List<SpecificationOption> findList(Map params) {
        return specificationOptionMapper.findList(params);
    }

    @Override
    public Long insertSpecificationOption(SpecificationOption specificationOption) {
        CheckUtils.notNull(specificationOption);
        specificationOptionMapper.insertSpecificationOption(specificationOption);
        return specificationOption.getId();
    }

    @Override
    public int insertSpecificationOption(List<SpecificationOption> options) {
        CheckUtils.notEmpty(options);
        return specificationOptionMapper.insertSpecificationOptions(options);
    }

    @Override
    public int updateSpecificationOption(SpecificationOption specificationOption) {
        CheckUtils.notNull(specificationOption);
        int size = specificationOptionMapper.updateSpecificationOption(specificationOption);
        CheckUtils.greaterThenZero(size);
        return size;
    }
}
