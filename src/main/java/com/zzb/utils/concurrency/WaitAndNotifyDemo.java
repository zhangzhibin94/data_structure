package com.zzb.utils.concurrency;

/**
 * @author 张志斌
 * @date 2020-02-23 16:32
 */
public class WaitAndNotifyDemo {
    private static  final Object obj = new Object();
    private static  boolean flag = true;
    private static final String WAIT_THREAD_NAME = "waitThread";
    private static final String NOTIFY_THREAD_NAME = "notifyThread";
    public static void main(String[] args) {
        Thread waitThread = new Thread(() -> {
            synchronized (obj){
                while (flag){
                    try {
                        System.out.println("当前线程：" +Thread.currentThread().getName() +",正在执行");
                        obj.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("当前线程：" +Thread.currentThread().getName() +",已经被唤醒");

        }, WAIT_THREAD_NAME);
        Thread notifyThread = new Thread(() -> {
            synchronized (obj){

                System.out.println("当前线程：" + Thread.currentThread().getName() + "正在执行");
                flag = false;
                SleepUtils.sleep(5L);
                obj.notify();
            }

        }, NOTIFY_THREAD_NAME);
        waitThread.start();
        notifyThread.start();
    }
}
