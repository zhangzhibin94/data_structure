package com.zzb.spring;


import com.zzb.spring.aop.AopConfig;
import com.zzb.spring.aop.AspectService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by 98684 on 2019/2/22.
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AopConfig.class);
        AspectService aspectService = (AspectService)app.getBean("aspectService");
        aspectService.hello("abc");
    }
}
