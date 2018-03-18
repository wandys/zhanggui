package com.shuidi.zhanggui.service.bl;


import com.shuidi.zhanggui.service.dal.entity.Goods;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by wandy on 2017-05-08.
 */
public interface GoodsService {
 /**
  * 通过id查找.
  *
  * @param id id
  * @return 查找结果
  */
 public Goods getById(Long id) throws ExecutionException, InterruptedException, TimeoutException;

 /**
  * 查找列表.
  *
  * @param params 查找条件
  * @return 列表结果
  */
 public List<Goods> findGoodsList(Map params) throws ExecutionException, InterruptedException, TimeoutException;

 /**
  * 插入新的数据.
  *
  * @param t 新数据
  * @return 影响行数
  */
 public Long insertGoods(Goods t);

 /**
  * 更新数据.
  *
  * @param t 待更新数据.
  * @return 更新结果
  */
 public int updateGoods(Goods t);

 }
