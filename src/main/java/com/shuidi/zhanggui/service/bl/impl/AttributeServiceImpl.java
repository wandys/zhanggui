package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.AttributeService;
import com.shuidi.zhanggui.service.dal.AttributeDao;
import com.shuidi.zhanggui.service.dal.entity.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("attributeService")
@Transactional
public class AttributeServiceImpl implements AttributeService {

  @Autowired
  private AttributeDao attributeDao;

  @Override
  public Attribute getById(Long id) {
    return attributeDao.getById(id);
  }

  @Override
  public List<Attribute> findAttributeList(Map params) {
    return attributeDao.findAttributeList(params);
  }

  @Override
  public int insertAttribute(Attribute t) {
    return attributeDao.insertAttribute(t);
  }

  @Override
  public int updateAttribute(Attribute t) {
    return attributeDao.updateAttribute(t);
  }
}
