package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.GoodsDao;
import com.shuidi.zhanggui.service.dal.entity.Goods;
import com.shuidi.zhanggui.service.dal.mappers.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("goodsDao")
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getById(Long id) {
        return goodsMapper.getById(id);
    }

    @Override
    public List<Goods> findList(Map params) {
        return goodsMapper.findList(params);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.update(goods);
    }
}
