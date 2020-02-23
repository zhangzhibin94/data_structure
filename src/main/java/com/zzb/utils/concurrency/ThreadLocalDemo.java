package com.zzb.utils.concurrency;

/**
 * @author 张志斌
 * @date 2020-02-23 17:08
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    private void before(){
        long startTime = System.currentTimeMillis();
        threadLocal.set(startTime);
    }

    private void after(){
        SleepUtils.sleep(5L);
        long endTime = System.currentTimeMillis();
        Long startTime = threadLocal.get();
        System.out.println("当前方法调用耗时" + (endTime - startTime) + "ms");
    }
    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.before();
        demo.after();
    }
}
