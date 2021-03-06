package com.shuidi.zhanggui.service.bl;


import com.shuidi.zhanggui.service.dal.entity.Specifications;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
public interface SpecificationsService {
 /**
  * 通过id查找.
  *
  * @param id id
  * @return 查找结果
  */
 public Specifications getById(Long id);

 /**
  * 查找列表.
  *
  * @param params 查找条件
  * @return 列表结果
  */
 public List<Specifications> findSpecificationsList(Map params);

 /**
  * 插入新的数据.
  *
  * @param t 新数据
  * @return 影响行数
  */
 public Long insertSpecifications(Specifications t);

 /**
  * 更新数据.
  *
  * @param t 待更新数据.
  * @return 更新结果
  */
 public int updateSpecifications(Specifications t);

 }
