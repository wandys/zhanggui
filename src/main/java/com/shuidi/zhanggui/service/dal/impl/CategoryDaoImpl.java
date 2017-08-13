package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.CategoryDao;
import com.shuidi.zhanggui.service.dal.entity.Category;
import com.shuidi.zhanggui.service.dal.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getById(Long id) {
        return categoryMapper.getById(id);
    }

    @Override
    public List<Category> findCategoryList(Map params) {
        return categoryMapper.findCategoryList(params);
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }
}
