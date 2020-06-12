package com.charli.lambda.juc;
/**
 * @Description : 利用join顺序执行线程
 * @Author xiaoli.cheng
 * @Date 2020/6/11 15:35
 */
public class JoinDemo {



    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(1);
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t1.join()之前");
                /**
                 * t1.join在t2线程中执行,join意思就是加入执行的意思, 就是当前线程(t2)执行到join代码时会停下,让这个join执行(t1)
                 * 在t2线程中如果t1.join的前面有代码执行,比如18行代码,那么正常跑代码的时候顺序应该是这样的
                 * 1.t2线程开始执行 -> 输出内容 -> t1.join代码执行 -> 执行t1的代码 -> 输出内容
                 *
                 * 从源码中可以得知，如果要join正常生效，调用join方法的对象必须已经调用了start()方法且并未进入终止状态。
                 */
                t1.join();
                System.out.println("t1.join()之后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(2);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("t2.join()之前");
                t2.join();
                System.out.println("t2.join()之后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(3);
            }
        });

        t3.start();
        t1.start();
        t2.start();

    }


}
