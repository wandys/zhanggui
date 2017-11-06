package com.shuidi.commons.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface ServiceSplitter<R> {


  /**
   * 添加新的拆分和合并选项.
   *
   * @param combiner 合并器
   * @param splitter 拆分器
   * @param <C>      中间类型
   */
  public <C> CompletableFuture addSplitter(BiConsumer<? super R, ? super C> combiner,
                                           Function<? super R, ? extends C> splitter);

  /**
   * 获取执行的结果.
   *
   * @return
   * @throws InterruptedException
   * @throws ExecutionException
   * @throws TimeoutException
   */
  public R get() throws InterruptedException, ExecutionException, TimeoutException;
}
