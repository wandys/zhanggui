package com.shuidi.zhanggui.service.dal;


import com.shuidi.zhanggui.service.dal.entity.TruckBase;

import java.util.List;

/**
 * Created by wandy on 2017-05-08.
 */
public interface TruckBaseDao {



    /**
     * 4.获取一个Bean实体
     * 注: 根据Bean实体的主键ID获取一个Bean实体.
     *
     * @param id - 唯一索引id，自增
     * @return TruckBase  - 执行结果
     * @throws Exception - 异常捕捉
     */
    public TruckBase getTruck(Long id) throws Exception;

    public List<TruckBase> getTrucks(Long enterpriseId);

}
