package com.shuidi.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 数据服务拆分器.
 *
 */
public class PojoServiceSplitter<R> implements ServiceSplitter<R> {

  private List<CompletableFuture> splitters = new ArrayList<>();

  private CompletableFuture<R> mainFuture;


  public PojoServiceSplitter(Supplier<R> mainFunction) {
    mainFuture = CompletableFuture.supplyAsync(mainFunction);
  }

  public static <U> PojoServiceSplitter<U> supplyAsync(Supplier<U> mainFunction) {
    return new PojoServiceSplitter<U>(mainFunction);
  }

  /**
   * 添加新的拆分和合并选项.
   *
   * @param combiner 合并器
   * @param splitter 拆分器
   * @param <C>      中间类型
   */
  public <C> CompletableFuture addSplitter(BiConsumer<? super R, ? super C> combiner,
                                              Function<? super R, ? extends C> splitter) {
    CompletableFuture<C> splitterFuture = mainFuture.thenApplyAsync(splitter);
    CompletableFuture combineFuture = mainFuture.thenAcceptBothAsync(splitterFuture, combiner);
    splitters.add(combineFuture);
    return combineFuture;
  }

  /**
   * 获取执行的结果,此方法会最多阻塞10s.
   *
   * @return
   * @throws InterruptedException
   * @throws ExecutionException
   * @throws TimeoutException
   */
  public R get() throws InterruptedException, ExecutionException, TimeoutException {
    CompletableFuture[] combineFutures = splitters.stream().toArray(CompletableFuture[]::new);
    CompletableFuture all = CompletableFuture.allOf(combineFutures);
    all.get(10, TimeUnit.SECONDS);
    return mainFuture.get();
  }

  public CompletableFuture<R> getMainFuture() {
    return mainFuture;
  }
}