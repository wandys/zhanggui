package com.shuidi.zhanggui.service.dal;

import com.shuidi.zhanggui.service.dal.entity.Shop;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-07-31.
 */
public interface ShopDao {

  /**
   * 根据id获取店铺信息.
   *
   * @param id            - 唯一索引id，自增
   * @return Shop         - 店铺信息
   */
  public Shop getShop(Long id);

  /**
   * 获取店铺的列表.
   *
   * @param map 查询条件
   * @return 结果集
   */
  public List<Shop> findShops(Map map);

  /**
   * 保存新的店铺信息.
   *
   * @param shop 店铺信息
   * @return 影响行数
   */
  public Long saveShop(Shop shop);

  /**
   * 更新店铺信息.
   *
   * @param shop 店铺信息
   * @return 更新影响行数
   */
  public Long updateShop(Shop shop);

  /**
   * 删除店铺信息.
   * <p>同时删除对应的坐标信息</p>
   *
   * @param shop 店铺id
   * @return 更新影响行数
   */
  public Long deleteShop(Shop shop);
}
