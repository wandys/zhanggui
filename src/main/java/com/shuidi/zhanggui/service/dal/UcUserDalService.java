package com.shuidi.zhanggui.service.dal;

import com.shuidi.zhanggui.service.dal.entity.UcUser;

import java.util.List;

/**
 * Created by wandy on 2017-05-21.
 */
public interface UcUserDalService {
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
    public void saveUcUser(UcUser user);

    /**
     * 更新用户信息
     *
     * @param user 待更新用户信息
     */
    public void updateUcUser(UcUser user);
}
