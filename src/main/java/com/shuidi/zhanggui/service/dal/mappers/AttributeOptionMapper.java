package com.shuidi.zhanggui.service.dal.mappers;

import com.shuidi.zhanggui.service.dal.entity.AttributeOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-07-31.
 */
@Mapper
public interface AttributeOptionMapper {
  /**
   * 通过id查找.
   *
   * @param id id
   * @return 查找结果
   */
  public AttributeOption getById(Long id);

  /**
   * 查找列表.
   *
   * @param params 查找条件
   * @return 列表结果
   */
  public List<AttributeOption> findList(Map params);

  /**
   * 插入新的数据.
   *
   * @param t 新数据
   * @return 影响行数
   */
  public int insertAttributeOption(AttributeOption t);

  /**
   * 更新数据.
   *
   * @param t 待更新数据.
   * @return 更新结果
   */
  public int updateAttributeOption(AttributeOption t);
}

