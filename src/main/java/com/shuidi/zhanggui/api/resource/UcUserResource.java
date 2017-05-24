package com.shuidi.zhanggui.api.resource;

import com.shuidi.zhanggui.service.dal.entity.UcUser;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户api返回的rest风格的hateoas
 *
 * Version 0.0.1
 * Create Time 2017-05-21.
 * Change Time 2017-05-21 19:46.
 */
public class UcUserResource extends ResourceSupport {

    private List<UcUser> ucUsers;

    public UcUserResource(){
        this.ucUsers = null;
    }
    public UcUserResource(UcUser user){
        List<UcUser> ucUsers = new ArrayList<>();
        ucUsers.add(user);
        this.ucUsers = ucUsers;
    }

    public UcUserResource(List<UcUser> users){
        this.ucUsers = users;
    }

    public List<UcUser> getUcUsers() {
        return ucUsers;
    }

    public void setUcUsers(List<UcUser> ucUsers) {
        this.ucUsers = ucUsers;
    }

}
