package com.charli.lambda.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Description : volatile特点: 可见性,禁止指令重排序 - 可见性
 * @Author xiaoli.cheng
 * @Date 2020/5/6 15:45
 */
public class T01_HelloVolatile {

//    boolean running = true;

    private volatile boolean running = true;

    void m(){
        System.out.println("m start");
        while (running){
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //加volatile,利用其可见性的特点, 每次更新通知其他线程去主内存拉取最新更新数据
        t.running = false;

    }

}
