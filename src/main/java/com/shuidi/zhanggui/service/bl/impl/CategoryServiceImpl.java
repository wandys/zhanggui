package com.shuidi.zhanggui.service.bl.impl;

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
  public int insertCategory(Category t) {
    return categoryDao.insertCategory(t);
  }

  @Override
  public int insertCategorys(List<Category> categories) {
    return categoryDao.insertCategorys(categories);
  }

  @Override
  public int updateCategory(Category t) {
    return categoryDao.updateCategory(t);
  }
}
