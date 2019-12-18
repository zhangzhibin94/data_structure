package com.zzb.spring.test;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author by 张志斌 .
 * @Date 10:14 2019/10/11
 */
public class ZzbFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
