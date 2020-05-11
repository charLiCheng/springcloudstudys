package com.charli.lambda.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Description : 缓存一致性协议
 * @Author xiaoli.cheng
 * @Date 2020/5/6 15:45
 */
public class T03_CacheLinePadding {
    public static volatile long[] arr = new long[16];

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10_0000_0000L; i++) {
                arr[0] = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10_0000_0000L; i++) {
                arr[8] = i;
            }
        });

        final long start = System.nanoTime();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println((System.nanoTime()-start)/100_0000);


    }


}
