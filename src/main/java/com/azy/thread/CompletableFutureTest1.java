package com.azy.thread;

import java.util.concurrent.*;

/**
 * 2023-11-02 16:08:24
 */
public class CompletableFutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }, threadPool).thenApply(f -> {
            System.out.println("222");
            int i = 10 / 0;
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("3333");
//            int i = 10 / 0;
            return f + 2;
        }).thenApply(f -> {
            System.out.println("4444");
            return f + 2;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("----计算结果" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getCause());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "------主线程先去做其他事情");
    }
}

