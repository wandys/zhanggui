package com.shuidi.zhanggui.service.dal.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * @实体名称 地址信息
 */
@Setter
@Getter
public class Position implements Serializable {

    /**
     * 唯一索引id，自增(必填项)(主键ID)
     */
    private Long id;

    /**
     *  店铺名称
     */
    private String address;
    /**
     * 店铺地址
     */
    private String position;
}

    