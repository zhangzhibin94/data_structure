package com.zzb.utils;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 15:18 2019/3/19
 */
public class JvmCount {
    private Object instance;
    /**
     * 成员变量
     */
    private Object obj = new Object();
    
    public void methodOne(int i){//
        int j = 0;  //iconst_0 :将int类型存入局部变量2
        int k = i+j;
        Object acb = obj;
        long start = System.currentTimeMillis();
        final int a = 0;
        methodTwo();
        return;
    }

    private String methodTwo() {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        StringBuilder sb = new StringBuilder();
        for(GarbageCollectorMXBean collectorMXBean:garbageCollectorMXBeans){
            sb.append(collectorMXBean.getName()+"\n");
        }
        return sb.toString();
    }

}
