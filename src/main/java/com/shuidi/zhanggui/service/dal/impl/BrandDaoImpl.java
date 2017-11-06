package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.cache.CacheInsert;
import com.shuidi.cache.CacheSelect;
import com.shuidi.cache.CacheUpdate;
import com.shuidi.cache.DataCacheType;
import com.shuidi.zhanggui.service.dal.BrandDao;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import com.shuidi.zhanggui.service.dal.entity.Position;
import com.shuidi.zhanggui.service.dal.entity.Shop;
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
    @CacheSelect(clearCache = true,
        listener = Brand.class,
        cachePojo = true)
    public Brand getById(Long id) {
        return brandMapper.getById(id);
    }

    @Override
    @CacheSelect(dataType = DataCacheType.list,
        cachePojo = true,
        clearCache = true,
        listener = {Brand.class})
    public List<Brand> findBrandList(Map params) {
        return brandMapper.findBrandList(params);
    }

    @Override
    @CacheInsert(dataType = DataCacheType.pojo)
    public int insertBrand(Brand brand) {
        return brandMapper.insertBrand(brand);
    }

    @Override
    @CacheUpdate(dataType = DataCacheType.pojo,
        clearCache = true,
        listener = {Brand.class})
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

}
