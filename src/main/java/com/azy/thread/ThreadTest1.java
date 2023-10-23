package com.azy.thread;
/*
* 线程创建的方式：
* 1、继承Thread类：
*   ①继承Thread类的子类
*   ②重写Thread的run()方法
*   ③创建子类对象
*   ④调用子类start()方法
*
* */

/*
* 线程常用的方法：
* -run()
* -start()
* -currentThread()静态方法，当前线程
* -getName()
* -setName()
* -yield()释放当前CPU
* -join()抢占CPU
* -sleep(ms)静态方法，单位毫秒
* -stop()已过时，结束线程
* -isActive()
* */

/*
* 线程的优先级：
* MAX_PRIORITY = 10
* MIN_PRIORITY = 1
* NORM_PRIORITY = 5
*
* getPriority()获取优先级
* setPriority(int p)设置优先级
* */

class MThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread m1 = new MThread();
        m1.start();
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

