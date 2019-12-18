package com.zzb.spring.spring;

import java.lang.annotation.*;


/**
 * Created by 98684 on 2019/2/22.
 */
//@Target用于描述注解可以作用的范围：构造器；方法；参数；域（就是字段、枚举的常量）；注解
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented//说明该注解将被包含在javadoc中
public @interface ZAutowired {
    boolean required() default true;
}
