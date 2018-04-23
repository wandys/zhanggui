/*
 * Created by wandy on 2018-04-23.
 */

package com.shuidi.commons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2018-04-23
 */
public class SerialNoGenerator {

  private static SnowFlake snowFlake;

  /**
   * 获取订单编号.
   *
   * @return 订单编号.
   */
  public static String orderNo() {
    SnowFlake snowFlake = getGenerator();
    String prefix = "SN";
    return generate(prefix, snowFlake.nextId());
  }

  /**
   * 获取商品编号.
   *
   * @return 商品编号
   */
  public static String goodsNo() {
    SnowFlake snowFlake = getGenerator();
    String prefix = "GN";
    return generate(prefix, snowFlake.nextId());
  }

  /**
   * 获取流水号.
   *
   * @return 流水号
   */
  public static String serialNo() {
    SnowFlake snowFlake = getGenerator();
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String prefix = localDate.format(formatter);
    return generate(prefix, snowFlake.nextId());
  }

  private static SnowFlake getGenerator() {
    if (snowFlake == null) {
      snowFlake = new SnowFlake(1L, 1L);
    }
    return snowFlake;
  }

  private static String generate(String prefix, Long no) {
    return prefix + no;
  }


}