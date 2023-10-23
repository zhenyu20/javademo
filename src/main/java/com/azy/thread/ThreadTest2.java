package com.azy.thread;

/*
 * 线程创建的方式：
 * 2、实现Runnable接口：
 *   ①实现Runnable接口的类
 *   ②重写Runnable的run()方法
 *   ③创建实现类的对象
 *   ④将实现类的对象作为参数创建Tread类
 *   ④调用Thread类的start()方法
 *
 * */

class MRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MRunnable mThread = new MRunnable();
        Thread thread = new Thread(mThread);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
