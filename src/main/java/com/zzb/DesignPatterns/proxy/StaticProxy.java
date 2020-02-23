package com.zzb.DesignPatterns.proxy;

/**
 * @Author by 张志斌 .
 * @Date 14:02 2019/4/15
 */
public class StaticProxy implements Person{
    private Person person;
    public void getTarget(Person target){
        this.person = target;
    }
    @Override
    public void findLove() {
        System.out.println("添加新功能A");
        person.findLove();
        System.out.println("添加新功能b");
    }
}
