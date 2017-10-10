package com.shuidi.zhanggui.service.dal.impl;

import com.shuidi.cache.CacheInsert;
import com.shuidi.cache.CacheUpdate;
import com.shuidi.cache.DataCacheType;
import com.shuidi.zhanggui.service.dal.ShopDao;
import com.shuidi.zhanggui.service.dal.entity.Shop;
import com.shuidi.zhanggui.service.dal.mappers.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("shopDao")
public class ShopDaoImpl implements ShopDao {

  @Autowired
  private ShopMapper shopMapper;

  @Override
  public Shop getShop(Long id) {
    return shopMapper.getShop(id);
  }

  @Override
  public List<Shop> findShops(Map map) {
    return shopMapper.findShops(map);
  }

  @Override
  @CacheInsert(dataType = DataCacheType.pojo)
  public Long saveShop(Shop shop) {
    shopMapper.saveShop(shop);
    return shop.getId();
  }

  @Override
  @CacheUpdate(dataType = DataCacheType.pojo)
  public Long updateShop(Shop shop) {
    return shopMapper.updateShop(shop);
  }

  @Override
  public Long deleteShop(Shop shop) {
    return shopMapper.deleteShop(shop);
  }
}
