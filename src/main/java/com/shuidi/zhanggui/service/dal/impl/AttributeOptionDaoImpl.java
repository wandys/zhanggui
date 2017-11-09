package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.commons.exception.ServiceException;
import com.shuidi.commons.utils.CheckUtils;
import com.shuidi.zhanggui.service.dal.AttributeOptionDao;
import com.shuidi.zhanggui.service.dal.entity.AttributeOption;
import com.shuidi.zhanggui.service.dal.mappers.AttributeOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("attributeOptionDao")
public class AttributeOptionDaoImpl implements AttributeOptionDao {

  @Autowired
  private AttributeOptionMapper attributeOptionMapper;

  @Override
  public AttributeOption getById(Long id) {
    CheckUtils.notNull(id);
    return attributeOptionMapper.getById(id);
  }

  @Override
  public List<AttributeOption> findAttributeOptionList(Map params) {
    return attributeOptionMapper.findList(params);
  }

  @Override
  public int insertAttributeOption(AttributeOption attributeOption) {
    CheckUtils.notNull(attributeOption);
    return attributeOptionMapper.insertAttributeOption(attributeOption);
  }

  @Override
  public int insertAttributeOptions(List<AttributeOption> options) {
    CheckUtils.notEmpty(options);
    return attributeOptionMapper.insertAttributeOptions(options);
  }

  @Override
  public int updateAttributeOption(AttributeOption attributeOption) {
    int size = attributeOptionMapper.updateAttributeOption(attributeOption);
    CheckUtils.greaterThenZero(size);
    return size;
  }
}
