package com.shuidi.uc.impl;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.shuidi.uc.service.bl.UcUserBlServie;
import com.shuidi.uc.service.dal.entity.UcUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wandy on 2017-05-23.
 */
public class UcUserBlServiceTest extends ServiceBaseTest {
    @Autowired
    private UcUserBlServie ucUserBlServie;

    @Test
    @DatabaseSetup({ "classpath:dataSets/userData.xml" })
    public void getUserById() throws Exception {
        UcUser user = ucUserBlServie.getUserById(10L);
        Assert.assertNotNull(user);
    }

    @Test
    public void findUcUsers() throws Exception {
    }

    @Test
    public void saveUcUser() throws Exception {

    }

    @Test
    public void updateUcUser() throws Exception {
    }

}