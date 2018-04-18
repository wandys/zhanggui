package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.utils.ListServiceSplitter;
import com.shuidi.commons.utils.PojoServiceSplitter;
import com.shuidi.commons.utils.ServiceSplitter;
import com.shuidi.zhanggui.service.bl.GoodsService;
import com.shuidi.zhanggui.service.bl.OrderService;
import com.shuidi.zhanggui.service.dal.BrandDao;
import com.shuidi.zhanggui.service.dal.CategoryDao;
import com.shuidi.zhanggui.service.dal.CommodityDao;
import com.shuidi.zhanggui.service.dal.GoodsDao;
import com.shuidi.zhanggui.service.dal.OrderDao;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Transactional
@Service("goodsService")
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;


  @Override
  public Order getById(Long id) {
    Objects.requireNonNull(id);
    return orderDao.getById(id);
  }

  @Override
  public List<Order> findOrderList(Map params) {
    Objects.requireNonNull(params);
    return orderDao.findOrderList(params);
  }

  @Override
  public Long insertOrder(Order t) {
    orderDao.insertOrder(t);
    return t.getId();
  }

  @Override
  public int updateOrder(Order t) {
    return orderDao.updateOrder(t);
  }
}
