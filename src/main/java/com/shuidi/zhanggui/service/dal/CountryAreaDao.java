package com.shuidi.zhanggui.service.dal;

import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import com.shuidi.zhanggui.service.dal.mappers.CountryAreaMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-29.
 */
public interface CountryAreaDao {

  public void insertAreas(List<CountryArea> countryAreas);

  public List<CountryArea> findAreas(Map<String,Object> params);
}
