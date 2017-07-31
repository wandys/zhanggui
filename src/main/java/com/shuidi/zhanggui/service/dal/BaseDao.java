package com.shuidi.zhanggui.service.dal;

import java.util.List;
import java.util.Map;

/**
 * 基础的mapper信息.
 *
 * Created by wandy on 2017-07-31.
 */
public interface BaseDao<T> {

    /**
     * 通过id查找.
     *
     * @param id id
     * @return 查找结果
     */
    public T getById(Long id);

    /**
     * 查找列表.
     *
     * @param params 查找条件
     * @return 列表结果
     */
    public List<T> findList(Map params);

    /**
     * 插入新的数据.
     *
     * @param t 新数据
     * @return 影响行数
     */
    public int insert(T t);

    /**
     * 更新数据.
     *
     * @param t 待更新数据.
     * @return 更新结果
     */
    public int update(T t);
}
