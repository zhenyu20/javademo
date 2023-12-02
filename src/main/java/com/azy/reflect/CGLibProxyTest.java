package com.azy.reflect;

/**
 * 2023-11-30 15:07:13
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        SmsServiceImpl smsServiceImpl = CGLibProxyUtil.createProxy(new SmsServiceImpl());
        smsServiceImpl.send("hello");
    }
}
