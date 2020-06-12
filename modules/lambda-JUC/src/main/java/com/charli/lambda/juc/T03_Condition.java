package com.charli.lambda.juc;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description : 线程交替输出 : 用了两个线程, 一个输出字母, 一个输出数字  , 交替输出1A2B3C4D...26Z
 *
 * @Author xiaoli.cheng
 * @Date 2020/5/8 14:42
 */
public class T03_Condition {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();


        new Thread(() -> {
            lock.lock();
            try {
                for (char a : aI) {
                    System.out.println(a);
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char a : aC) {
                    System.out.println(a);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t2").start();


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("这是== %d").build();
        Thread t3 = namedThreadFactory.newThread(() -> {
            System.out.println(111);
        });
        t3.start();
        String name = t3.getName();
        System.out.println("name == "+name);
        Thread t4 = namedThreadFactory.newThread(() -> {
            System.out.println(222);
        });
        t4.start();
        String name1 = t4.getName();
        System.out.println("name1 == "+name1);
    }

}
