package com.charli.lambda.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2020/6/2 16:27
 */
public class T01_AtomicInteger {

    AtomicInteger count = new AtomicInteger(0);
//    private volatile Integer count = 0;

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
//            count++;
        }
    }

    public static void main(String[] args) {
        T01_AtomicInteger t = new T01_AtomicInteger();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread - "+i));
        }

        threads.forEach(p->{
            p.start();
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        threads.forEach(p->{
//            try {
//                p.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        System.out.println(t.count.get());
    }
}
