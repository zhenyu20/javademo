package com.azy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2023-11-30 14:46:33
 */
public class JDKProxyUtil{
    public static SmsService createProxy(SmsService smsService){
        return (SmsService) Proxy.newProxyInstance(JDKProxyUtil.class.getClassLoader(),
                new Class[]{SmsService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("send".equals(method.getName())){
                            System.out.println("发送消息前");
                        }
                        return method.invoke(smsService,args);
                    }
                });
    }
}
