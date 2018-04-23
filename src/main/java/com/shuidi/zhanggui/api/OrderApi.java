package com.shuidi.zhanggui.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.SerialNoGenerator;
import com.shuidi.commons.exception.CheckedException;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.zhanggui.service.bl.OrderService;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.entity.Order;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping(value = "/order")
@ExposesResourceFor(Order.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class OrderApi {

  @Autowired
  private OrderService orderService;

  @Autowired
  private EntityLinks entityLinks;

  /**
   * 获取订单信息.
   *
   * @return
   */
  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getOrderDetail(@PathVariable Long id) {
    if (id == null) {
      throw new CheckedException("id can't be null");
    }
    Order order = orderService.getById(id);
    Link selfLink = entityLinks.linkToSingleResource(Goods.class, order.getId());
    SingleResource<JSONObject> resource = new SingleResource(order);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 获取订单信息.
   *
   * @return
   */
  @RequestMapping(value = "/no/{no}", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getOrder(@PathVariable String no) {
    if (StringUtils.isBlank(no)) {
      throw new CheckedException("id can't be null");
    }
    Map<String, Object> params = new HashMap<>();
    params.put("no", no);
    List<Order> orders = orderService.findOrderList(params);
    Link selfLink = entityLinks.linkToSingleResource(Order.class, "${id}");
    CollectsResource<JSONObject> resource = new CollectsResource(orders);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 根据登录用户获取订单列表信息.
   *
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity getOrders(@RequestBody Order order) {
    if (order == null) {
      throw new CheckedException("order can't be null");
    }
    Map<String, Object> params = new HashMap<>();
    params.put("id", order.getId());
    params.put("no", order.getNo());
    List<Order> goodss = orderService.findOrderList(params);
    Link selfLink = entityLinks.linkToSingleResource(Order.class, "${id}");
    CollectsResource<JSONObject> resource = new CollectsResource(goodss);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 更新订单信息.
   *
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity updateOrder(@RequestBody Order order) {
    if (order == null || order.getId() == null) {
      throw new CheckedException("order can't be null");
    }
    orderService.updateOrder(order);
    Link selfLink = entityLinks.linkToSingleResource(Order.class, "${id}");
    SingleResource<JSONObject> resource = new SingleResource(order);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 新增店铺信息.
   *
   * @return
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity addOrder(@RequestBody Order order) {
    if (order == null) {
      throw new CheckedException("order can't be null");
    }
    order.setNo(SerialNoGenerator.orderNo());
    order.setCreateTime(new Date());
    order.setGoodsDeatil(JSONObject.toJSONString(order.getOrderGoods()));
    Long orderId = orderService.insertOrder(order);
    Link selfLink = entityLinks.linkToSingleResource(Order.class, orderId);
    SingleResource<JSONObject> resource = new SingleResource(orderId);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

}
