package com.zzb.utils.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author 张志斌
 * @date 15:49:00 2020-02-23
 */
public class SemaphoreDemo {
    /**
     * 最大连接数
     */
    private static volatile Semaphore connection = new Semaphore(1);

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(() -> {
                System.out.println("线程:" + Thread.currentThread() + " 尝试提交数据到数据库");
                try {
                    connection.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程:" + Thread.currentThread() + "提交数据成功");
                //释放连接
                connection.release();
            });
            thread.start();
        }
    }
}
