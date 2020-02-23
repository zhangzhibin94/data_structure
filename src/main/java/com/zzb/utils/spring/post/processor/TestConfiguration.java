package com.zzb.utils.spring.post.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zzb.utils.*")
public class TestConfiguration {
    @Bean
    public Moon getMoon(){
        return new Moon();
    }
}
