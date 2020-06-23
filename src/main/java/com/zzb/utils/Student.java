package com.zzb.utils;

import org.msgpack.annotation.Message;

/**
 * @Author by 张志斌 .
 * @Date 14:20 2019/3/15
 * Message 表示需要进行msgPack进行序列化
 */
@Message
public class Student {
    private String name;
    private String description;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{"+this.name+","+this.age + ","+this.description+"}";
    }
}
