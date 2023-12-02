package com.azy.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 2023-11-20 16:42:41
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() ->{
            try{
                lock.lock();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();
    }
}
