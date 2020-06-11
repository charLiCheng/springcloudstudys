package com.charli.lambda.juc;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

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

//        Lock lock = new ReentrantLock();
//        Condition c1 = lock.newCondition();
//        Condition c2 = lock.newCondition();
//
//
//        new Thread(() -> {
//            lock.lock();
//            try {
//                for (char a : aI) {
//                    System.out.println(a);
//                    c2.signal();
//                    c1.await();
//                }
//                c2.signal();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//
//        },"t1").start();
//
//        new Thread(() -> {
//            lock.lock();
//            try {
//                for (char a : aC) {
//                    System.out.println(a);
//                    c1.signal();
//                    c2.await();
//                }
//                c1.signal();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//
//        },"t2").start();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("这是-%d").build();

        String s = "124";
        String a = "-123.246";
        try {
            double v = Double.parseDouble(s);
            double v1 = Double.parseDouble(a);
            int i = Integer.parseInt(s);
            System.out.println(v1+"=="+v);
        } catch (NumberFormatException e) {
            System.out.println("出错了");
        }

        String REGEX = "^((\\d|[1-9]\\d|100)(\\.\\d{1,2}))|(\\d|[1-9]\\d|100)$";

        boolean matches = Pattern.matches(REGEX, "23");
        System.out.println(matches);
        boolean matches1 = Pattern.matches(REGEX, "23.0");
        System.out.println(matches1);
        boolean matches2 = Pattern.matches(REGEX, "23.12");
        System.out.println(matches2);
        boolean matches3 = Pattern.matches(REGEX, "23.123");
        System.out.println(matches3);
        boolean matches4 = Pattern.matches(REGEX, "-23.12");
        System.out.println(matches4);
        boolean matches5 = Pattern.matches(REGEX, "0.0");
        System.out.println(matches5);

        double v2 = Double.parseDouble(a);
        System.out.println(v2<0);

        BigDecimal completeNum = new BigDecimal("1");
        BigDecimal allNum = new BigDecimal("3");
        BigDecimal multiply = completeNum.divide(allNum, 2, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
        System.out.println(multiply);
        double aaa = Double.parseDouble("2");
        double bbb = Double.parseDouble("5");
        double ccc =(aaa / bbb)*100;

        BigDecimal divide = new BigDecimal(String.valueOf(ccc)).setScale(2,BigDecimal.ROUND_DOWN);
        String s1 = divide.stripTrailingZeros().toPlainString();
        divide = new BigDecimal(divide.stripTrailingZeros().toPlainString());
        System.out.println(divide);
        System.out.println(ccc);


    }

}
