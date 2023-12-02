package com.azy.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 2023-11-30 14:59:11
 */
public class CGLibProxyUtil {
    public static SmsServiceImpl createProxy(SmsServiceImpl smsService){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(SmsServiceImpl.class.getClassLoader());
        enhancer.setSuperclass(SmsServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            //代理对象、原方法、参数、代理方法
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if("send".equals(method.getName())){
                    System.out.println("发送消息前");
                }
                return methodProxy.invokeSuper(o,objects);//必须是invokeSuper
            }
        });
        return (SmsServiceImpl) enhancer.create();
    }
}
