package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CommodityAttributeOptionService;
import com.shuidi.zhanggui.service.dal.CommodityAttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommodityAttributeOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("commodityAttributeOptionService")
@Transactional
public class CommodityAttributeOptionServiceImpl implements CommodityAttributeOptionService {

  @Autowired
  private CommodityAttributeOptionDao commodityAttributeOptionDao;

  @Override
  public CommodityAttributeOption getById(Long id) {
    return commodityAttributeOptionDao.getById(id);
  }

  @Override
  public List<CommodityAttributeOption> findList(Map params) {
    return commodityAttributeOptionDao.findList(params);
  }

  @Override
  public int insertCommmodityAttributeOption(CommodityAttributeOption t) {
    return commodityAttributeOptionDao.insertCommmodityAttributeOption(t);
  }

  @Override
  public int updateCommmodityAttributeOption(CommodityAttributeOption t) {
    return commodityAttributeOptionDao.updateCommmodityAttributeOption(t);
  }
}
