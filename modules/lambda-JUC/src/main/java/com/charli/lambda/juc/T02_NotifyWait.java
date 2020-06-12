package com.charli.lambda.juc;


/**
 * @Description : 线程交替输出 : 用了两个线程, 一个输出字母, 一个输出数字  , 交替输出1A2B3C4D...26Z
 * 利用LockSupport的park和unpark特点交替输出两个线程的东西
 * 思想: 有点像生产者消费者的模式, 也不太像, 就是一个线程先输出点东西,然后唤醒其他线程,锁自己,
 * 交替输出肯定就是两个线程完成的东西了,唤醒其他锁自己 , 另一个输出后唤醒其他锁自己
 * @Author xiaoli.cheng
 * @Date 2020/5/8 14:42
 */
public class T02_NotifyWait {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        Object o = new Object();

        t1 = new Thread(() -> {
            synchronized (o) {
                for (char a : aI) {   //数字
                    System.out.println(a);
                    try {
                        o.notifyAll();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }

        });

        t2 = new Thread(() -> {
            synchronized (o){
                for (char a : aC) {   //字母
                    try {
                        System.out.println(a);
                        o.notifyAll();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                /*
                * 其实如果是t2最后输出G,那么t2必然会唤醒t1,然后把自己锁住
                * 这时t1被唤醒 , for循环时发现已经输出完了,不会执行for里面的(唤醒别的线程然后锁住自己线程)代码了
                * 这时t1线程会直接执行到32行(o.notifyAll)代码,唤醒t2线程 , 然后t1线程的代码执行结束
                * 接着t2执行到for循环,发现for也执行完毕,线程结束
                * 所以按照这个执行逻辑,t2的线程最后可以不用执行o.notifyAll , 但是如果是两个以上的话应该是多需要唤醒的
                * */
                o.notifyAll();
            }

        });

        t1.start();
        t2.start();
    }

}
