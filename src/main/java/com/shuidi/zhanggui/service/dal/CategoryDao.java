package com.shuidi.zhanggui.service.dal;

import com.shuidi.zhanggui.service.dal.entity.Category;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-07-31.
 */
public interface CategoryDao {

  /**
   * 通过id查找.
   *
   * @param id id
   * @return 查找结果
   */
  public Category getById(Long id);

  /**
   * 查找列表.
   *
   * @param params 查找条件
   * @return 列表结果
   */
  public List<Category> findCategoryList(Map params);

  /**
   * 插入新的数据.
   *
   * @param t 新数据
   * @return 影响行数
   */
  public int insertCategory(Category t);

  public int insertCategorys(List<Category> categories);

  /**
   * 更新数据.
   *
   * @param t 待更新数据.
   * @return 更新结果
   */
  public int updateCategory(Category t);
}
