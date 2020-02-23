package com.zzb.utils.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 张志斌
 * @date 2020-02-23 12:13
 */
public class CyclicBarrierDemo {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        for(int i = 0; i < 4; i++){
            Thread thread = new Thread(() -> {
                System.out.println("当前线程：" + Thread.currentThread() + "正在执行");
                try {
                    cyclicBarrier.await();
                    System.out.println("当前线程：" + Thread.currentThread() +"已经重启启动");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

    }
}
