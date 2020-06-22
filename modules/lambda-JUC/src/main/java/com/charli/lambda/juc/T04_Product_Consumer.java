package com.charli.lambda.juc;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * @Description : 两个生产者10个消费者
 * @Author xiaoli.cheng
 * @Date 2020/6/22 10:50
 */
public class T04_Product_Consumer<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        //判断是否是满的
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //不满则添加
        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        //是否是空的
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有值则获取值
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        T04_Product_Consumer<String> con = new T04_Product_Consumer<>();
        //消费者
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println("这是 : "+ con.get());
                }
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产者
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    con.put(Thread.currentThread().getName()+" : "+j);
                }
            },"p"+i).start();
        }

    }

}
