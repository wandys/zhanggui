package com.shuidi.commons.utils;


@FunctionalInterface
public interface PredicateFunction<T,R> {

  R apply(T t);

  default boolean test(T t) {
    if (apply(t) == null) {
      return false;
    }
    return true;
  }
}
