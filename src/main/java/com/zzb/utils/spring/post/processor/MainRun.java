package com.zzb.utils.spring.post.processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRun {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);

    }
}
