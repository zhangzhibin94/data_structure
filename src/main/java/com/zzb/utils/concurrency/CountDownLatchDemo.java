package com.zzb.utils.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author 张志斌
 * @date 16:58 2020-02-22
 */
public class CountDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        for(int i = 0; i < 15; i++){
            Thread thread = new Thread(()->{
                System.out.println("当前线程为："+Thread.currentThread().getName()+"正在执行," + countDownLatch.getCount());

            });
            thread.start();
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("阻塞结束");

    }

}
