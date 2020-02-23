package com.zzb.utils.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author 张志斌
 * @date 2020-02-23 20:35
 */
public class FutureTaskDemo {
    public static class Call implements Callable<Integer>{
        static Random random = new Random();
        @Override
        public Integer call() throws Exception {
            return random.nextInt();
        }

    }

    public static void main(String[] args) {
        Call call = new Call();
        FutureTask<Integer> futureTask = new FutureTask<>(call);
        new Thread(futureTask).start();
        if(Call.random.nextBoolean()){
            try {
                System.out.println("任务执行了，返回值是：" + futureTask.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("我被中断了");
            futureTask.cancel(true);
        }
    }
}
