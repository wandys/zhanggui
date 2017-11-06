package com.shuidi.zhanggui.api;

import com.alibaba.fastjson.JSONObject;
import com.shuidi.commons.exception.CheckedException;
import com.shuidi.commons.exception.ServiceException;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.SingleResource;
import com.shuidi.uc.api.shiro.LoginTools;
import com.shuidi.zhanggui.service.bl.GoodsService;
import com.shuidi.zhanggui.service.bl.ShopServie;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.entity.Shop;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping(value = "/good")
@ExposesResourceFor(Shop.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class GoodsApi {

  @Autowired
  private GoodsService goodsService;

  @Autowired
  private EntityLinks entityLinks;

  /**
   * 根据登录用户获取店铺信息.
   *
   * @return
   */
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getGood(@PathVariable Long id) throws InterruptedException, ExecutionException, TimeoutException {
    if (id == null) {
      throw new CheckedException("id can't be null");
    }
    Goods goods = goodsService.getById(id);
    Link selfLink = entityLinks.linkToSingleResource(Shop.class, "${id}");
    SingleResource<JSONObject> resource = new SingleResource(goods);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }
  /**
   * 根据登录用户获取店铺信息.
   *
   * @return
   */
  @RequestMapping(value = "/",method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity getGoods(@RequestBody Goods goods) throws InterruptedException, ExecutionException, TimeoutException {
    if (goods == null) {
      throw new CheckedException("id can't be null");
    }
    Map<String,Object> params = new HashMap<>();
    params.put("categoryId",goods.getCategoryId());
    List<Goods> goodss = goodsService.findGoodsList(params);
    Link selfLink = entityLinks.linkToSingleResource(Shop.class, "${id}");
    CollectsResource<JSONObject> resource = new CollectsResource(goodss);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }
}
