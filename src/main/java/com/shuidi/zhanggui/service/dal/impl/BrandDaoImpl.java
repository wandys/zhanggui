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
    public List<Brand> findBrandList(Map params) {
        return brandMapper.findBrandList(params);
    }

    @Override
    public int insertBrand(Brand brand) {
        return brandMapper.insertBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

}
