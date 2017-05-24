package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.TruckBaseService;
import com.shuidi.zhanggui.service.dal.TruckBaseDao;
import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wandy on 2017-05-08.
 */
@Service("truckBaseService")
public class TruckBaseServiceImpl implements TruckBaseService {

    @Autowired
    private TruckBaseDao truckBaseDao;

    @Override
    public TruckBase getById(Long id) throws Exception {
        return truckBaseDao.getTruck(id);
    }

    @Override
    public List<TruckBase> getTrucks(Long enterpriseId) {
        return truckBaseDao.getTrucks(enterpriseId);
    }
}
