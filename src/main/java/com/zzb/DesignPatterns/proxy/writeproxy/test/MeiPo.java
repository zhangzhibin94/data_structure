package com.zzb.DesignPatterns.proxy.writeproxy.test;

import com.zzb.DesignPatterns.proxy.Person;
import com.zzb.DesignPatterns.proxy.writeproxy.ZClassLoader;
import com.zzb.DesignPatterns.proxy.writeproxy.ZInvocationHandler;
import com.zzb.DesignPatterns.proxy.writeproxy.ZProxy;

import java.lang.reflect.Method;

/**
 * @Author by 张志斌 .
 * @Date 12:46 2019/4/17
 */
public class MeiPo implements ZInvocationHandler {

    Person target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用了代理类开始------------------------------------");
        System.out.println(this.target.getClass());
        this.target.findLove();
        System.out.println("调用了代理类结束------------------------------------");
        return null;
    }

    public Object getInstance(Person obj){
        this.target = obj;
        Class<? extends Person> clazz = target.getClass();
        return ZProxy.newProxyInstance(new ZClassLoader(), clazz.getInterfaces(), this);
    }
}
