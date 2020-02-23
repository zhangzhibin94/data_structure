package com.zzb.utils.spring.ioc.overview.domain;

import org.springframework.beans.factory.BeanFactory;

public class UserRepository {
    private SuperUser superUser;
    private BeanFactory beanFactory;

    public SuperUser getSuperUser() {
        return superUser;
    }

    public void setSuperUser(SuperUser superUser) {
        this.superUser = superUser;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
