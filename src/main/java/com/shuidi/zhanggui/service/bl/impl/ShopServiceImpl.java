package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.utils.PojoServiceSplitter;
import com.shuidi.commons.utils.ServiceSplitter;
import com.shuidi.zhanggui.service.bl.ShopServie;
import com.shuidi.zhanggui.service.dal.ShopDao;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Transactional
@Service("shopServie")
public class ShopServiceImpl implements ShopServie {

  @Autowired
  private ShopDao shopDao;

  @Override
  public Shop getShop(Long id) throws InterruptedException, ExecutionException, TimeoutException {
    ServiceSplitter<Shop> pojoServiceSplitter = PojoServiceSplitter.supplyAsync(() ->
        shopDao.getShop(id));
    return pojoServiceSplitter.get();
  }

  @Override
  public List<Shop> findShops(Map map) {
    return shopDao.findShops(map);
  }

  @Override
  public Long saveShop(Shop shop) {
    return shopDao.saveShop(shop);
  }

  @Override
  public Long updateShop(Shop shop) {
    return shopDao.updateShop(shop);
  }

  @Override
  public Long deleteShop(Shop shop) {
    return shopDao.deleteShop(shop);
  }
}
