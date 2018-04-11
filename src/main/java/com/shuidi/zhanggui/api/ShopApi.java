package com.shuidi.zhanggui.api;

import com.shuidi.commons.enums.Status;
import com.shuidi.commons.resource.CollectsResource;
import com.shuidi.commons.resource.OnlyResource;
import com.shuidi.uc.api.shiro.LoginTools;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 17-8-6.
 */
//@RestControlle
@Controller
@RequestMapping(value = "/shop")
@ExposesResourceFor(Shop.class)
@EnableEntityLinks
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class ShopApi {

  @Autowired
  private ShopServie shopServie;

  @Autowired
  private EntityLinks entityLinks;

  /**
   * 根据登录用户获取店铺信息.
   *
   * @return
   */
  @RequestMapping(value = "/",method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getLoginShops() {
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

  /**
   * 添加新店铺.
   *
   * @param shop 新店铺
   * @return
   */
  @RequestMapping(value = "/",method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity saveShop(@RequestBody Shop shop) {
    shop.setPositionId(1l);
    shop.setUserId(LoginTools.getLonginUser().getId());
    shop.setStatus(Status.ENABLED);
    shop.setOperateId(LoginTools.getLonginUser().getId());
    Long id = shopServie.saveShop(shop);
    Link selfLink = entityLinks.linkToSingleResource(Shop.class, id);
    OnlyResource resource = new OnlyResource();
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

  /**
   * 更新店铺.
   *
   * @param shop 新店铺
   * @return
   */
  @RequestMapping(value = "/{shopId}",method = RequestMethod.PATCH)
  @ResponseBody
  public ResponseEntity updateShop(@PathVariable Long shopId,@RequestBody Shop shop) {
    shop.setId(shopId);
    shop.setOperateId(LoginTools.getLonginUser().getId());
    Long id = shopServie.updateShop(shop);
    Link selfLink = entityLinks.linkToSingleResource(Shop.class, shopId);
    OnlyResource resource = new OnlyResource();
    resource.add(selfLink);
    return ResponseEntity.ok(resource);
  }

}
