package com.zzb.utils.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author 张志斌
 * @date 2020-2-23 16:41
 */
public class SleepUtils {
    public static void sleep(Long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
