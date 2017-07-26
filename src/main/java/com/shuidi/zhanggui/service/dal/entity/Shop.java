package com.shuidi.zhanggui.service.dal.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @实体名称 店铺
 */
@Setter
@Getter
public class Shop implements Serializable {

    /**
     * 唯一索引id，自增(必填项)(主键ID).
     */
    private Long id;

    /**
     *  店铺名称.
     */
    private String name;

    /**
     *  店铺状态.
     */
    private String status;

    /**
     * 店铺地址.
     */
    private Long positionId;

    /**
     * logo地址.
     */
    private String logoImage;

    /**
     * 所属用户id.
     */
    private Long userId;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

    /**
     * 操作人id.
     */
    private Long operateId;

    /**
     * 位置信息.
     */
    private Position position;

}

    