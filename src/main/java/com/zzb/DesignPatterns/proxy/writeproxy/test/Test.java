package com.zzb.DesignPatterns.proxy.writeproxy.test;

import com.zzb.DesignPatterns.proxy.Person;
import com.zzb.DesignPatterns.proxy.UserA;

/**
 * @Author by 张志斌 .
 * @Date 12:48 2019/4/17
 */
public class Test {
    public static void main(String[] args) {
        Person person = (Person) new MeiPo().getInstance(new UserA());
        System.out.println();
    }
}
