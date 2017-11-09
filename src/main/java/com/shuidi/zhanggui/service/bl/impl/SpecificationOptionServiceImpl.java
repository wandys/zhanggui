package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.utils.CheckUtils;
import com.shuidi.zhanggui.service.bl.SpecificationOptionService;
import com.shuidi.zhanggui.service.dal.SpecificationOptionDao;
import com.shuidi.zhanggui.service.dal.entity.SpecificationOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("specificationOptionService")
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

  @Autowired
  private SpecificationOptionDao specificationOptionDao;

  @Override
  public SpecificationOption getById(Long id) {

    return specificationOptionDao.getById(id);
  }

  @Override
  public List<SpecificationOption> findList(Map params) {
    return specificationOptionDao.findList(params);
  }

  @Override
  public Long insertSpecificationOption(SpecificationOption t) {

    return specificationOptionDao.insertSpecificationOption(t);
  }

  @Override
  public int insertSpecificationOption(List<SpecificationOption> options) {
    return specificationOptionDao.insertSpecificationOption(options);
  }

  @Override
  public int updateSpecificationOption(SpecificationOption t) {

    return specificationOptionDao.updateSpecificationOption(t);
  }
}
