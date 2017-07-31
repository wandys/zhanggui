package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.BrandDao;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import com.shuidi.zhanggui.service.dal.mappers.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("brandDao")
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand getById(Long id) {
        return brandMapper.getById(id);
    }

    @Override
    public List<Brand> findList(Map params) {
        return brandMapper.findList(params);
    }

    @Override
    public int insert(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.update(brand);
    }
}
