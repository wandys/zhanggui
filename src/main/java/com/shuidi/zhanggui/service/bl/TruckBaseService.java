package com.shuidi.zhanggui.service.bl;


import com.shuidi.zhanggui.service.dal.entity.TruckBase;

import java.util.List;

/**
 * Created by wandy on 2017-05-08.
 */
public interface TruckBaseService {

    public TruckBase getById(Long id) throws Exception;

    public List<TruckBase> getTrucks(Long enterpriseId);
 }
