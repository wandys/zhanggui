package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.ShopServie;
import com.shuidi.zhanggui.service.dal.ShopDao;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("shopServie")
public class ShopServiceImpl implements ShopServie {

  @Autowired
  private ShopDao shopDao;

  @Override
  public Shop getShop(Long id) {
    return shopDao.getShop(id);
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
