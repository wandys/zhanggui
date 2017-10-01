package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CountryAreaService;
import com.shuidi.zhanggui.service.dal.CountryAreaDao;
import com.shuidi.zhanggui.service.dal.entity.CountryArea;
import com.shuidi.zhanggui.service.dal.mappers.CountryAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-29.
 */
@Transactional
@Service("countryAreaService")
public class CountryAreaServiceImpl implements CountryAreaService {

  @Autowired
  private CountryAreaDao countryAreaDao;

  @Autowired
  private RedisTemplate redisTemplate;

  @Override
  public void insertAreas(List<CountryArea> countryAreas) {
    countryAreaDao.insertAreas(countryAreas);
  }

  @Override
  public List<CountryArea> findAreas(Map<String, Object> params) {
    return countryAreaDao.findAreas(params);
  }
}
