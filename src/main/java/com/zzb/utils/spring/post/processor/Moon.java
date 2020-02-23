package com.zzb.utils.spring.post.processor;

import org.springframework.stereotype.Component;


public class Moon {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Moon(){
        System.out.println("moon无参构造被调用");
    }
}
