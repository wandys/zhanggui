package com.shuidi.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 数据服务拆分器.
 */
public class ListServiceSplitter<R>/* implements ServiceSplitter<R>*/ {

  private List<CompletableFuture> splitters = new ArrayList<>();

  private CompletableFuture<List<R>> mainFuture;


  public ListServiceSplitter(Supplier<List<R>> mainFunction) {
    mainFuture = CompletableFuture.supplyAsync(mainFunction);
  }

  public static <U> ListServiceSplitter<U> supplyAsync(Supplier<List<U>> mainFunction) {
    return new ListServiceSplitter<U>(mainFunction);
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
    CompletableFuture<List<C>> splitterFuture = mainFuture.thenApplyAsync(datas -> {
      datas.forEach(data -> {
        PojoServiceSplitter<R> pojoServiceSplitter = PojoServiceSplitter.supplyAsync(() -> data);
        CompletableFuture combineFuture = pojoServiceSplitter.addSplitter(combiner, splitter);
        splitters.add(combineFuture);
        splitters.add(pojoServiceSplitter.getMainFuture());
      });

      return null;
    });
    splitters.add(splitterFuture);
    return splitterFuture;
  }

  /**
   * 获取执行的结果,此方法会最多阻塞10s.
   *
   * @return
   * @throws InterruptedException
   * @throws ExecutionException
   * @throws TimeoutException
   */
  public List<R> get() throws InterruptedException, ExecutionException, TimeoutException {
    CompletableFuture[] combineFutures = splitters.stream().toArray(CompletableFuture[]::new);
    CompletableFuture all = CompletableFuture.allOf(combineFutures);
    all.get(10, TimeUnit.SECONDS);
    return mainFuture.get();
  }
}