package com.shuidi.zhanggui.api;

import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.uc.api.shiro.LoginTools;
import com.shuidi.zhanggui.service.bl.GoodsService;
import com.shuidi.zhanggui.service.bl.ShopServie;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
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
  @RequestMapping(value = "/",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getGood() {
    /*if (LoginTools.isLogin()) {
      throw new ServiceException("测试异常");
    }*/
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put("userId", LoginTools.getLonginUser().getId());
    List<Shop> shops = shopServie.findShops(searchMap);
    Link selfLink = entityLinks.linkToSingleResource(Shop.class, "${id}");
    CollectsResource<Shop> resource = new CollectsResource(shops);
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }
}
