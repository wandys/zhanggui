package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.utils.PojoServiceSplitter;
import com.shuidi.zhanggui.service.bl.CommodityService;
import com.shuidi.zhanggui.service.dal.CommodityAttributeOptionDao;
import com.shuidi.zhanggui.service.dal.CommodityDao;
import com.shuidi.zhanggui.service.dal.CommoditySepcificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service("commodityService")
@Transactional
public class CommodityServiceImpl implements CommodityService {

  @Autowired
  private CommodityDao commodityDao;
  @Autowired
  private CommodityAttributeOptionDao commodityAttributeOptionDao;
  @Autowired
  private CommoditySepcificationOptionDao commoditySepcificationOptionDao;

  @Override
  public Commodity getById(Long id) throws InterruptedException, ExecutionException, TimeoutException {
    PojoServiceSplitter<Commodity> pojoServiceSplitter = PojoServiceSplitter.supplyAsync(() -> commodityDao.getById(id));
    pojoServiceSplitter.addSplitter(Commodity::setCommmodityAttributeOptions,commodity -> {
      Map<String,Object> searchMap = new HashMap<>();
      searchMap.put("commodityId",commodity.getId());
      return commodityAttributeOptionDao.findList(searchMap);
    });
    pojoServiceSplitter.addSplitter(Commodity::setCommoditySepcificationOptions, commodity -> {
      Map<String,Object> searchMap = new HashMap<>();
      searchMap.put("commodityId",commodity.getId());
      return commoditySepcificationOptionDao.findList(searchMap);
    });
    return pojoServiceSplitter.get();
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
