package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CommodityService;
import com.shuidi.zhanggui.service.dal.CommodityDao;
import com.shuidi.zhanggui.service.dal.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("commodityService")
@Transactional
public class CommodityServiceImpl implements CommodityService {

  @Autowired
  private CommodityDao commodityDao;

  @Override
  public Commodity getById(Long id) {
    return commodityDao.getById(id);
  }

  @Override
  public List<Commodity> findCommodityList(Map params) {
    return commodityDao.findCommodityList(params);
  }

  @Override
  public int insertCommodity(Commodity t) {
    return commodityDao.insertCommodity(t);
  }

  @Override
  public int updateCommodity(Commodity t) {
    return commodityDao.updateCommodity(t);
  }
}
