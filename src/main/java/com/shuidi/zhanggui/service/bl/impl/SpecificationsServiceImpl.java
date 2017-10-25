package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.SpecificationsService;
import com.shuidi.zhanggui.service.dal.SpecificationsDao;
import com.shuidi.zhanggui.service.dal.entity.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("specificationsService")
public class SpecificationsServiceImpl implements SpecificationsService {

  @Autowired
  private SpecificationsDao specificationsDao;

  @Override
  public Specifications getById(Long id) {
    return specificationsDao.getById(id);
  }

  @Override
  public List<Specifications> findSpecificationsList(Map params) {
    return specificationsDao.findList(params);
  }

  @Override
  public int insertSpecifications(Specifications t) {
    return specificationsDao.insertSpecifications(t);
  }

  @Override
  public int updateSpecifications(Specifications t) {
    return specificationsDao.updateSpecifications(t);
  }
}
