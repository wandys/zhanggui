package com.shuidi.uc.service.dal.impl;

import com.shuidi.uc.service.dal.UcUserDalService;
import com.shuidi.uc.service.dal.entity.UcUser;
import com.shuidi.uc.service.dal.mappers.UcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Describe :
 * <p>
 * Created by wandy .
 * <p>
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 19:33.
 */
@Service(value = "ucUserDalService")
public class UcUserDalServiceImpl implements UcUserDalService {

    @Autowired
    private UcUserMapper ucUserMapper;

    @Override
    public UcUser getUserById(Long userId) {
        return ucUserMapper.getUserById(userId);
    }

    @Override
    public List<UcUser> findUcUsers(UcUser user) {
        return ucUserMapper.findUcUsers(user);
    }

    @Override
    public void saveUcUser(UcUser user) {
        ucUserMapper.saveUcUser(user);
    }

    @Override
    public void updateUcUser(UcUser user) {
        ucUserMapper.updateUcUser(user);
    }
}
