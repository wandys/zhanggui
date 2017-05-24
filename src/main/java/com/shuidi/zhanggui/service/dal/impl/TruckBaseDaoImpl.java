package com.shuidi.zhanggui.service.dal.impl;


import com.shuidi.zhanggui.service.dal.TruckBaseDao;
import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import com.shuidi.zhanggui.service.dal.mappers.TruckBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("truckBaseDao")
public class TruckBaseDaoImpl implements TruckBaseDao {

    @Autowired
    private TruckBaseMapper truckBaseMapper;

    @Override
    public TruckBase getTruck(Long id) throws Exception {
        return truckBaseMapper.getTruck(id);
    }

    @Override
    public List<TruckBase> getTrucks(Long enterpriseId) {
        return truckBaseMapper.getTrucks(enterpriseId);
    }
}
