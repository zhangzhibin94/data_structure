package com.zzb.DesignPatterns.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author by 张志斌 .
 * @Date 9:53 2019/4/15
 * 代理人
 */
public class PersonJDKLib implements InvocationHandler {

    private Person person;
    /**
     * 获取被代理人的个人资料
     * @param target
     * @return
     * @throws Exception
     */
    public Object getInstance(Person target) throws Exception{
        this.person = target;
        Class clazz = target.getClass();
        //生成一个代理对象，最后一个参数为代理人
        Person o = (Person)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用了代理类开始------------------------------------");
        System.out.println(this.person.getClass());
        this.person.findLove();
        System.out.println("调用了代理类结束------------------------------------");
        return null;
    }

    public static void main(String[] args) throws Exception {
        Person instance = (Person)new PersonJDKLib().getInstance(new UserA());
        instance.findLove();
        System.out.println(instance.getClass());
        //获取字节码内容
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{instance.getClass()});
        FileOutputStream fos = new FileOutputStream(new File("$Proxy0.class"));
        fos.write(bytes);
        fos.close();
    }
}
