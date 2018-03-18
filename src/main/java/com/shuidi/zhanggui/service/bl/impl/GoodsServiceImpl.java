package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.commons.utils.ListServiceSplitter;
import com.shuidi.commons.utils.PojoServiceSplitter;
import com.shuidi.commons.utils.ServiceSplitter;
import com.shuidi.zhanggui.service.bl.GoodsService;
import com.shuidi.zhanggui.service.dal.BrandDao;
import com.shuidi.zhanggui.service.dal.CategoryDao;
import com.shuidi.zhanggui.service.dal.CommodityDao;
import com.shuidi.zhanggui.service.dal.GoodsDao;
import com.shuidi.zhanggui.service.dal.entity.Brand;
import com.shuidi.zhanggui.service.dal.entity.Category;
import com.shuidi.zhanggui.service.dal.entity.Commodity;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Transactional
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsDao goodsDao;

  @Autowired
  private BrandDao brandDao;

  @Autowired
  private CategoryDao categoryDao;


  @Autowired
  private CommodityDao commodityDao;

  @Override
  public Goods getById(Long id) throws ExecutionException, InterruptedException, TimeoutException {

    ServiceSplitter<Goods> pojoServiceSplitter = PojoServiceSplitter.supplyAsync(() ->
        goodsDao.getById(id));
    pojoServiceSplitter.addSplitter(Goods::setBrand, good -> brandDao.getById(good.getBrandId()));
    pojoServiceSplitter.addSplitter(Goods::setCategory, good -> categoryDao.getById(good.getCategoryId()));
    pojoServiceSplitter.addSplitter(Goods::setCommodities, good -> {
      Map<String,Object> search = new HashMap<>();
      search.put("goodsId",good.getId());
      return commodityDao.findCommodityList(search);
    });

    return pojoServiceSplitter.get();

  }

  @Override
  public List<Goods> findGoodsList(Map params) throws ExecutionException, InterruptedException, TimeoutException {
    ListServiceSplitter<Goods> listServiceSplitter = ListServiceSplitter.supplyAsync(() ->
        goodsDao.findGoodsList(params));
    listServiceSplitter.addSplitter(Goods::setBrand, good -> brandDao.getById(good.getBrandId()));
    listServiceSplitter.addSplitter(Goods::setCategory, good -> categoryDao.getById(good.getCategoryId()));
    listServiceSplitter.addSplitter(Goods::setCommodities, good -> {
      Map<String,Object> search = new HashMap<>();
      search.put("goodsId",good.getId());
      return commodityDao.findCommodityList(search);
    });
    return listServiceSplitter.get();
  }

  @Override
  public Long insertGoods(Goods t) {
    goodsDao.insertGoods(t);
    return t.getId();
  }

  @Override
  public int updateGoods(Goods t) {
    return goodsDao.updateGoods(t);
  }
}
