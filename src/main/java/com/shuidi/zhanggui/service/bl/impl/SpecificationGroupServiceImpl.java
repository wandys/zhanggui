package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.SpecificationGroupService;
import com.shuidi.zhanggui.service.dal.SpecificationGroupDao;
import com.shuidi.zhanggui.service.dal.entity.SpecificationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("specificationGroupService")
public class SpecificationGroupServiceImpl implements SpecificationGroupService {

  @Autowired
  private SpecificationGroupDao specificationGroupDao;

  @Override
  public SpecificationGroup getById(Long id) {
    return specificationGroupDao.getById(id);
  }

  @Override
  public List<SpecificationGroup> findSpecificationGroupList(Map params) {
    return specificationGroupDao.findList(params);
  }

  @Override
  public int insertSpecificationGroup(SpecificationGroup t) {
    return specificationGroupDao.insertSpecificationGroup(t);
  }

  @Override
  public int updateSpecificationGroup(SpecificationGroup t) {
    return specificationGroupDao.updateSpecificationGroup(t);
  }
}
