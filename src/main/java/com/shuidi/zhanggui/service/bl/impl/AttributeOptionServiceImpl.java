package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.AttributeOptionService;
import com.shuidi.zhanggui.service.dal.AttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.AttributeOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("attributeOptionService")
@Transactional
public class AttributeOptionServiceImpl implements AttributeOptionService {

  @Autowired
  private AttributeOptionDao attributeOptionDao;

  @Override
  public AttributeOption getById(Long id) {
    return attributeOptionDao.getById(id);
  }

  @Override
  public List<AttributeOption> findAttributeOptionList(Map params) {
    return attributeOptionDao.findAttributeOptionList(params);
  }

  @Override
  public int insertAttributeOption(AttributeOption t) {
    return attributeOptionDao.insertAttributeOption(t);
  }

  @Override
  public int updateAttributeOption(AttributeOption t) {
    return attributeOptionDao.updateAttributeOption(t);
  }
}
