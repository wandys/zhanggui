package com.shuidi.uc.service.bl;

import com.shuidi.uc.service.dal.entity.UcUser;

import java.util.List;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 19:38.
 */
public interface UcUserBlServie {
    /**
     * 根据用户id查询用户信息.
     *
     * @param userId 用户id
     * @return 用户信息
     */
    public UcUser getUserById(Long userId);

    /**
     * 根据条件查询用户信息.
     *
     * @param user 查询条件
     * @return 结果集
     */
    public List<UcUser> findUcUsers(UcUser user);

    /**
     * 保存用户信息.
     *
     * @param user 用户信息
     */
    public Long saveUcUser(UcUser user);

    /**
     * 更新用户信息
     *
     * @param user 待更新用户信息
     */
    public void updateUcUser(UcUser user);
}
