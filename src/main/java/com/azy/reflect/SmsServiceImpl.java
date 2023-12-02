package com.azy.reflect;

/**
 * 2023-11-30 14:44:25
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("发送消息:" + message);
        return message;
    }
}
