package com.shuidi.zhanggui.service.dal.impl;


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
        return specificationOptionMapper.getById(id);
    }

    @Override
    public List<SpecificationOption> findList(Map params) {
        return specificationOptionMapper.findList(params);
    }

    @Override
    public int insert(SpecificationOption specificationOption) {
        return specificationOptionMapper.insert(specificationOption);
    }

    @Override
    public int update(SpecificationOption specificationOption) {
        return specificationOptionMapper.update(specificationOption);
    }
}
