package com.azy.thread;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * 2023-11-01 15:16:18
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "hhhhhhhhhhhhh---------");
            return null;
        }, threadPool);

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "hhhhhhhhhhhhhhhhhhhhhhhh");
        }, threadPool);

        try {
            System.out.println(cf.get());
            System.out.println(cf2.get());

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        threadPool.shutdown();
    }
}
