package com.zzb.utils.concurrency.cas;

import com.zzb.utils.spring.ioc.overview.domain.User;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 张志斌
 * @date 2020-02-23 21:55
 */
public class AtomicReferenceDemo {
    private static AtomicStampedReference<User> userAtomicReference = new AtomicStampedReference<>(new User(), 0);

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        userAtomicReference.set(user, 1);
        User user2 = new User();
        user2.setName("张三2");
        userAtomicReference.set(user, 1);
        System.out.println(userAtomicReference.getReference().getName());
    }
}
