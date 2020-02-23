package com.zzb.utils.spring.bean.beanDefinition;

import com.zzb.utils.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author 张志斌
 * description:beanDefinition创建方法
 */
public class BeanDefinitionDemo{

    public static volatile BeanDefinitionDemo instance;

    public static BeanDefinitionDemo getInstance(){
        if(instance == null){
            synchronized (BeanDefinitionDemo.class){
                if(instance == null){
                    System.out.println("初始化了");
                    instance = new BeanDefinitionDemo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        for(int i = 1; i < 100; i++){
            Thread thread = new Thread(()->{
                System.out.println("当前线程为:" + Thread.currentThread().getName()+", instance = " + getInstance());

            });
            thread.start();
        }

        //1.通过beanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","zzb");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println("通过beanDefinitionBuilder构造的对象的className：" + beanDefinition.getBeanClassName());
        System.out.println("属性name：" + beanDefinition.getPropertyValues().getPropertyValue("name").getValue());

        //2.通过abstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name","李四");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        genericBeanDefinition.setLazyInit(true);
        System.out.println("通过abstractBeanDefinition以及派生类构造的对象的className：" + genericBeanDefinition.getBeanClassName());
        System.out.println("属性name：" + genericBeanDefinition.getPropertyValues().getPropertyValue("name").getValue());

    }


}
