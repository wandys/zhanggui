package com.shuidi.zhanggui.service.dal.impl;

import com.shuidi.zhanggui.service.dal.CountryAreaDao;
import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import com.shuidi.zhanggui.service.dal.mappers.CountryAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-29.
 */
@Repository("countryAreaDao")
public class CountryAreaDaoImpl implements CountryAreaDao {

  @Autowired
  private CountryAreaMapper areaMapper;

  @Override
  public void insertAreas(List<CountryArea> countryAreas) {
    areaMapper.insertAreas(countryAreas);
  }

  @Override
  public List<CountryArea> findAreas(Map<String, Object> params) {
    return areaMapper.findAreas(params);
  }
}
