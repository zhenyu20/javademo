package com.azy.thread;

/**
 * 2023-10-27 19:53:08
 * <a href="https://www.cnblogs.com/luonote/p/10347427.html">...</a>
 */
//饿汉式：
public class Singleton1 {
    // 1.私有化构造器
    private Singleton1() {
    }

    // 2.内部提供一个当前类的实例
    // 4.此实例也必须静态化
    private static final Singleton1 single = new Singleton1();

    // 3.提供公共的静态的方法，返回当前类的对象
    public static Singleton1 getInstance() {
        return single;
    }
}

//懒汉式：双重判断
class Singleton2 {
    // 1.私有化构造器
    private Singleton2() {
    }

//    private static Singleton2 instance = null;
    private volatile static Singleton2 instance = null;//volatile防止序列重排

    // 3.提供公共的静态的方法，返回当前类的对象
    public static Singleton2 getInstance() {
        if (instance == null) {//效率更高
            synchronized (Singleton2.class) {//同步锁
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

//在方法上加同步锁，效率低
class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 instance = null;

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

class Singleton4 {
    private Singleton4() {
    }

    private static final class InstanceHolder {
        static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return InstanceHolder.instance;
    }
}
