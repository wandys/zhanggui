package com.shuidi.zhanggui.service.dal.mappers;

import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-29.
 */
@Mapper
public interface CountryAreaMapper {

  public void insertAreas(List<CountryArea> countryAreas);

  public List<CountryArea> findAreas(Map<String,Object> params);
}
