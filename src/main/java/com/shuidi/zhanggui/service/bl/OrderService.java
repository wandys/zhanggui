package com.shuidi.zhanggui.service.bl;


import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.entity.Order;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by wandy on 2017-05-08.
 */
public interface OrderService {
  /**
   * 通过id查找.
   *
   * @param id id
   * @return 查找结果
   */
  public Order getById(Long id);

  /**
   * 查找列表.
   *
   * @param params 查找条件
   * @return 列表结果
   */
  public List<Order> findOrderList(Map params);

  /**
   * 插入新的数据.
   *
   * @param t 新数据
   * @return 影响行数
   */
  public Long insertOrder(Order t);

  /**
   * 更新数据.
   *
   * @param t 待更新数据.
   * @return 更新结果
   */
  public int updateOrder(Order t);

}
