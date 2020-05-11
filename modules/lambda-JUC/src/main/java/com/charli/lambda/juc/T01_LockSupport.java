package com.charli.lambda.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description : 线程交替输出 : 用了两个线程, 一个输出字母, 一个输出数字  , 交替输出1A2B3C4D...26Z
 *  利用LockSupport的park和unpark特点交替输出两个线程的东西
 *  思想: 有点像生产者消费者的模式, 也不太像, 就是一个线程先输出点东西,然后唤醒其他线程,锁自己,
 *  交替输出肯定就是两个线程完成的东西了,唤醒其他锁自己 , 另一个输出后唤醒其他锁自己
 * @Author xiaoli.cheng
 * @Date 2020/5/8 14:42
 */
public class T01_LockSupport {

    static Thread t1 = null , t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (int i = 0; i< aI.length ; i++){
                System.out.println(aI[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i< aI.length ; i++){
                LockSupport.park();
                System.out.println(aC[i]);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }

}
