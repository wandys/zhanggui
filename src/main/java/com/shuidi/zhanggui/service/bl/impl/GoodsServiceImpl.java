package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.GoodsService;
import com.shuidi.zhanggui.service.dal.GoodsDao;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsDao goodsDao;

  @Override
  public Goods getById(Long id) {
    return goodsDao.getById(id);
  }

  @Override
  public List<Goods> findGoodsList(Map params) {
    return goodsDao.findGoodsList(params);
  }

  @Override
  public int insertGoods(Goods t) {
    return goodsDao.insertGoods(t);
  }

  @Override
  public int updateGoods(Goods t) {
    return goodsDao.updateGoods(t);
  }
}
