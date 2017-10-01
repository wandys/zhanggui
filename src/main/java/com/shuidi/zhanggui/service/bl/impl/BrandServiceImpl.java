package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.BrandService;
import com.shuidi.zhanggui.service.dal.BrandDao;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-6.
 */
@Transactional
@Service("brandService")
public class BrandServiceImpl implements BrandService {

  @Autowired
  private BrandDao brandDao;

  @Override
  public Brand getById(Long id) {
    return brandDao.getById(id);
  }

  @Override
  public List<Brand> findBrandList(Map params) {
    return brandDao.findBrandList(params);
  }

  @Override
  public int insertBrand(Brand brand) {
    return brandDao.insertBrand(brand);
  }

  @Override
  public int updateBrand(Brand brand) {
    return brandDao.updateBrand(brand);
  }
}
