package com.zzb.utils.spring.ioc.overview;

import com.zzb.utils.spring.ioc.overview.annotation.Super;
import com.zzb.utils.spring.ioc.overview.domain.User;
import com.zzb.utils.spring.ioc.overview.domain.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class MainRun {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
//        getBeanByAnnotation(beanFactory);
        getUserRepository(beanFactory);
    }

    private static void getUserRepository(BeanFactory beanFactory) {
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        System.out.println(userRepository.getBeanFactory());
    }

    private static void getBeanByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User> userMap = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(userMap);
        }
    }
}
