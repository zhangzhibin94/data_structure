package com.zzb.utils.spring.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestBeanFactoryPostProcessors implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("-----------调用自定义后置处理器"+this.getClass().getName());
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        System.out.println("一共有"+beanFactory.getBeanDefinitionCount()+"个beanDefinition");
    }
}
