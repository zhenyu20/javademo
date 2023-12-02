package com.azy.reflect;

/**
 * 2023-11-30 14:51:45
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        SmsService smsService = JDKProxyUtil.createProxy(new SmsServiceImpl());
        smsService.send("hello");
    }
}
