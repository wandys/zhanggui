package com.shuidi.zhanggui.service.bl.impl;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.shuidi.cache.PojoCompareResult;
import com.shuidi.cache.PojoCompareUtil;
import com.shuidi.commons.enums.Status;
import com.shuidi.zhanggui.service.bl.ShopServie;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImplTest extends ServiceBaseTest {

  @Autowired
  private ShopServie shopServie;

  @Test
  @DatabaseSetup({"classpath:dataSets/shopData.xml"})
  public void getShop() throws Exception {
    Shop shop = shopServie.getShop(1l);
    Assert.assertNotNull(shop);
  }

  @Test
  @DatabaseSetup({"classpath:dataSets/shopData.xml"})
  public void findShops() throws Exception {
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put("userId", 1);
    List<Shop> shops = shopServie.findShops(searchMap);
    Assert.assertNotNull(shops);
    Assert.assertEquals(2, shops.size());
  }

  @Test
  @DatabaseSetup({"classpath:dataSets/shopData.xml"})
  public void saveShop() throws Exception {
    Shop shop = new Shop();
    shop.setLogoImage("111111");
    shop.setName("111111");
    shop.setPositionId(1l);
    shop.setUserId(1l);
    shop.setStatus(Status.ENABLED);
    shop.setOperateId(1l);
    Long id = shopServie.saveShop(shop);
    Assert.assertNotNull(id);
  }

  @Test
  @DatabaseSetup({"classpath:dataSets/shopData.xml"})
  public void updateShop() throws Exception {
    Shop shop = new Shop();
    shop.setId(1L);
    shop.setLogoImage("222222");
    shop.setName("111111");
    shop.setPositionId(1l);
    shop.setUserId(1l);
    shop.setStatus(Status.DISABLED);
    shop.setOperateId(1l);
    Long id = shopServie.updateShop(shop);
    //Assert.assertNotNull(id);
    //Assert.assertTrue(id > 0);
  }

  @Test
  @DatabaseSetup({"classpath:dataSets/shopData.xml"})
  public void deleteShop() throws Exception {
    Shop shop = new Shop();
    shop.setId(1L);
    shop.setLogoImage("111111");
    shop.setName("111111");
    shop.setPositionId(1l);
    shop.setUserId(1l);
    shop.setStatus(Status.DELETED);
    shop.setOperateId(1l);
    Long id = shopServie.updateShop(shop);
    Shop shopNew = shopServie.getShop(id);
    Assert.assertEquals(Status.DELETED, shopNew.getStatus());
  }

  @Test
  public void pojoCompareTest() {
    Shop shop1 = new Shop();
    shop1.setId(1L);
    shop1.setLogoImage("111111");
    shop1.setName("111111");
    shop1.setPositionId(1l);
    shop1.setUserId(1l);
    shop1.setStatus(Status.DELETED);
    shop1.setOperateId(1l);

    Shop shop2 = new Shop();
    shop2.setId(2L);
    shop2.setLogoImage("");
    shop2.setName("111111");
    shop2.setPositionId(1l);
    shop2.setUserId(1l);
    shop2.setStatus(Status.DELETED);
    shop2.setOperateId(1l);

    List<PojoCompareResult> results =
        PojoCompareUtil.compare(shop1,shop2, PojoCompareUtil.CompareFeature.StringEmptyAsNull);
    results.size();
  }



}