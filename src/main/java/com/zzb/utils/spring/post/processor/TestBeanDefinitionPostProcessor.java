package com.zzb.utils.spring.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TestBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry在这里被调用了哦，beanDefinition的数量是："+beanDefinitionRegistry.getBeanDefinitionCount() );
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Moon.class);
        beanDefinitionRegistry.registerBeanDefinition("moonBeanDefinition", rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory，beanDefinition的数量是："+configurableListableBeanFactory.getBeanDefinitionCount() );

    }
}
