package com.zzb.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author by 张志斌 .
 * @Date 10:17 2019/10/11
 */
@Configuration
public class MainConfigure {
    @Bean
    public ZzbFactoryBean zzbFactoryBean(){
        return new ZzbFactoryBean();
    }
}
