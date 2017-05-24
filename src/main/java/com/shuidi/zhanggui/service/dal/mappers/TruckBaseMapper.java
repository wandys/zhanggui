package com.shuidi.zhanggui.service.dal.mappers;

import com.shuidi.zhanggui.service.dal.entity.TruckBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @实体名称 好气网车辆ID与智慧物流车辆ID映射关系表
 * @数据库表 TRUCK_BASE
 * @开发日期 2017-05-08
 * @技术服务 www.fwjava.com
 */
@Mapper
public interface TruckBaseMapper {

    /**
     * 4.获取一个Bean实体
     * 注: 根据Bean实体的主键ID获取一个Bean实体.
     * @param id          - 唯一索引id，自增
     * @return TruckBase  - 执行结果
     */
    public TruckBase getTruck(Long id);

    /**
     * 获取车辆的列表
     *
     * @param enterpriseId 企业id
     * @return 结果集
     */
    public List<TruckBase> getTrucks(Long enterpriseId);
}
