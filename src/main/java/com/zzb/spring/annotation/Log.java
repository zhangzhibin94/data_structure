package com.zzb.spring.annotation;

import java.lang.annotation.*;

/**
 * @Author by 张志斌 .
 * @Date 14:52 2019/10/21
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 应用名称
     * @return
     */
    String applicationName() default "";

    /**
     * 操作名称
     * @return
     */
    String operatorName();
}
