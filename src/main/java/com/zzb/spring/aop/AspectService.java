package com.zzb.spring.aop;

import com.zzb.spring.annotation.Log;
import org.springframework.stereotype.Service;

/**
 * @Author by 张志斌 .
 * @Date 14:10 2019/10/21
 */
@Service
public class AspectService {
    @Log(operatorName = "添加", applicationName = "")
    public void hello(String name){
        System.out.println("我是一个业务方法啊,我的name:"+name);
    }
}
