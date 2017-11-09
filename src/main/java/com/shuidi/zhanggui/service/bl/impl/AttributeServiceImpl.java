package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.exception.ServiceException;
import com.shuidi.commons.utils.CheckUtils;
import com.shuidi.zhanggui.service.bl.AttributeOptionService;
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
  @Autowired
  private AttributeOptionService attributeOptionService;

  @Override
  public Attribute getById(Long id) {
    return attributeDao.getById(id);
  }

  @Override
  public List<Attribute> findAttributeList(Map params) {
    return attributeDao.findAttributeList(params);
  }

  @Override
  public Long insertAttribute(Attribute t) {
    CheckUtils.notNull(t);
    attributeDao.insertAttribute(t);
    if (!CheckUtils.isEmpty(t.getAttributeOptions())) {
      t.getAttributeOptions().forEach(attributeOption -> attributeOption.setAttributeId(t.getId()));
      attributeOptionService.insertAttributeOptions(t.getAttributeOptions());
    }
    return t.getId();
  }

  @Override
  public int updateAttribute(Attribute t) {
    int size = attributeDao.updateAttribute(t);
    CheckUtils.greaterThenZero(size);
    return size;
  }
}
