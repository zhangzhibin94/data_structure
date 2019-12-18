package com.zzb.DesignPatterns.proxy.writeproxy;

import java.lang.reflect.Method;

/**
 * @Author by 张志斌 .
 * @Date 12:42 2019/4/17
 */
public interface ZInvocationHandler {
     Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
