package com.zzb.DesignPatterns.proxy;

/**
 * @Author by 张志斌 .
 * @Date 13:03 2019/4/15
 */
public class UserA implements Person {

    @Override
    public void findLove() {
        System.out.println("调用了被代理类UserA");
    }
}
