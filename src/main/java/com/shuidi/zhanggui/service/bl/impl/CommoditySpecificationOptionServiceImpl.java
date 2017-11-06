package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.CommoditySpecificationOptionService;
import com.shuidi.zhanggui.service.dal.CommoditySepcificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.CommoditySepcificationOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("commoditySpecificationOptionService")
public class CommoditySpecificationOptionServiceImpl implements CommoditySpecificationOptionService {

  @Autowired
  private CommoditySepcificationOptionDao commoditySepcificationOptionDao;

  @Override
  public CommoditySepcificationOption getById(Long id) {
    return commoditySepcificationOptionDao.getById(id);
  }

  @Override
  public List<CommoditySepcificationOption> findList(Map params) {
    return commoditySepcificationOptionDao.findList(params);
  }

  @Override
  public int insertCommonditySepcificationOption(CommoditySepcificationOption t) {
    return commoditySepcificationOptionDao.insertCommonditySepcificationOption(t);
  }

  @Override
  public int updateCommonditySepcificationOption(CommoditySepcificationOption t) {
    return commoditySepcificationOptionDao.updateCommonditySepcificationOption(t);
  }
}
