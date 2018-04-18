package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.OrderDao;
import com.shuidi.zhanggui.service.dal.entity.Order;
import com.shuidi.zhanggui.service.dal.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("orderDao")
public class OrderDaoImpl implements OrderDao {

  @Autowired
  private OrderMapper orderMapper;

  @Override
  public Order getById(Long id) {
    return orderMapper.getById(id);
  }

  @Override
  public List<Order> findOrderList(Map params) {
    return orderMapper.findList(params);
  }

  @Override
  public int insertOrder(Order order) {
    return orderMapper.insert(order);
  }

  @Override
  public int updateOrder(Order order) {
    return orderMapper.update(order);
  }
}
