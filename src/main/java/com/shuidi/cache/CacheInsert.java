/*
 * Created by wandy on 2017-09-25.
 */

package com.shuidi.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wandy
 * @version 0.0.1
 * @since 0.0.1 2017-09-25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheInsert {

  public DataCacheType dataType() default DataCacheType.pojo;

  public String keyField() default "id";
}