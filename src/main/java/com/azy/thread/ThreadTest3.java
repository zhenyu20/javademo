package com.azy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 *
 * 实现Callable接口创建线程
 * */
class MCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("dddddd");
        return 1;
    }
}
public class ThreadTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MCallable mc = new MCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        new Thread(ft, "t1").start();
        System.out.println(ft.isDone());//轮询
        System.out.println(ft.get());//阻塞
    }
}
