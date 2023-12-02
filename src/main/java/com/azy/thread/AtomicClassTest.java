package com.azy.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2023-11-18 19:20:48
 */
public class AtomicClassTest {
    public static void main(String[] args) throws InterruptedException {
        IncreaseInteger val = new IncreaseInteger();
//        IncreaseInteger1 val = new IncreaseInteger1();
//        IncreaseInteger2 val = new IncreaseInteger2();
        System.out.println(val.get());

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                val.increase();
//                System.out.println(Thread.currentThread().getName() + ":" + val.get());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                val.increase();
//                System.out.println(Thread.currentThread().getName() + ":" +  val.get());
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(val.get());
    }
}

class IncreaseInteger {
    AtomicInteger value = new AtomicInteger(1);

    public void increase() {
        value.incrementAndGet();
    }

    public Integer get() {
        return value.get();
    }
}

class IncreaseInteger1 {

    private volatile Integer value = 1;

    public synchronized void increase() {
        value++;
    }

    public Integer get() {
        return value;
    }
}

class IncreaseInteger2 {

    private Integer value = 1;

    public void increase() {
        value++;
    }

    public Integer get() {
        return value;
    }
}
