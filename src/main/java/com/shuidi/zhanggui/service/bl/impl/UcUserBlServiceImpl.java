package com.shuidi.zhanggui.service.bl.impl;

import com.shuidi.zhanggui.service.bl.UcUserBlServie;
import com.shuidi.zhanggui.service.dal.UcUserDalService;
import com.shuidi.zhanggui.service.dal.entity.UcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户中心用户service.
 *
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 19:38.
 */

@Service("ucUserBlServie")
@Transactional
public class UcUserBlServiceImpl implements UcUserBlServie {

    @Autowired
    private UcUserDalService ucUserDalService;

    @Override
    public UcUser getUserById(Long userId) {
        if (userId == null) {
            throw new NullPointerException("user id can't bee null");
        }
        return ucUserDalService.getUserById(userId);
    }

    @Override
    public List<UcUser> findUcUsers(UcUser user) {
        if (user == null) {
            throw new NullPointerException("find user Params can't bee null");
        }
        return ucUserDalService.findUcUsers(user);
    }

    @Override
    public Long saveUcUser(UcUser user) {
        if (user == null) {
            throw new NullPointerException("save user can't bee null");
        }
        ucUserDalService.saveUcUser(user);

        return user.getId();
    }

    @Override
    public void updateUcUser(UcUser user) {
        if (user == null) {
            throw new NullPointerException("update user params can't bee null");
        }
        ucUserDalService.updateUcUser(user);
    }
}
