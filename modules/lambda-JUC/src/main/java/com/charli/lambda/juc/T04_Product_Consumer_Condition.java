package com.charli.lambda.juc;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @Description : 两个生产者10个消费者
 * @Author xiaoli.cheng
 * @Date 2020/6/22 10:50
 */
public class T04_Product_Consumer_Condition<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition product = lock.newCondition();

    public void put(T t) {
        //判断是否是满的
        lock.lock();
        try {
            while (list.size() == MAX) {
                try {
                    product.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //不满则添加
            list.add(t);
            ++count;
            consumer.signal();//消费者可以消费了
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        //是否是空的
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0) {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有值则获取值
            t = list.removeFirst();
            count--;
            product.signalAll();//通知生产者生产了
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        T04_Product_Consumer_Condition<String> con = new T04_Product_Consumer_Condition<>();
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
