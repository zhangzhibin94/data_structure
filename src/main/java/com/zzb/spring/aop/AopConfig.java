package com.zzb.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author by 张志斌 .
 * @Date 14:12 2019/10/21
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value="com.zzb.*")
public class AopConfig {
}
