package com.shuidi.zhanggui.service.dal.mappers;

import com.shuidi.zhanggui.service.dal.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-07-31.
 * Change Time 2017-07-31 19:58.
 */
@Mapper
public interface BrandMapper {

  /**
   * 通过id查找.
   *
   * @param id id
   * @return 查找结果
   */
  public Brand getById(Long id);

  /**
   * 查找列表.
   *
   * @param params 查找条件
   * @return 列表结果
   */
  public List<Brand> findBrandList(Map params);

  /**
   * 插入新的数据.
   *
   * @param t 新数据
   * @return 影响行数
   */
  public int insertBrand(Brand t);

  /**
   * 更新数据.
   *
   * @param t 待更新数据.
   * @return 更新结果
   */
  public int updateBrand(Brand t);

}
