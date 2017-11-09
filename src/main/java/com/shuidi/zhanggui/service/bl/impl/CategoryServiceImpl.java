package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.exception.ServiceException;
import com.shuidi.commons.utils.CheckUtils;
import com.shuidi.zhanggui.service.bl.CategoryService;
import com.shuidi.zhanggui.service.dal.CategoryDao;
import com.shuidi.zhanggui.service.dal.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDao categoryDao;

  @Override
  public Category getById(Long id) {
    return categoryDao.getById(id);
  }

  @Override
  public List<Category> findCategoryList(Map params) {
    return categoryDao.findCategoryList(params);
  }

  @Override
  public Long insertCategory(Category t) {
    categoryDao.insertCategory(t);
    return t.getId();
  }

  @Override
  public int insertCategorys(List<Category> categories) {
    return categoryDao.insertCategorys(categories);
  }

  @Override
  public int updateCategory(Category t) {
    int size = categoryDao.updateCategory(t);
    CheckUtils.greaterThenZero(size);
    return size;
  }
}
