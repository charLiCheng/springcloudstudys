package com.charli.lambda.juc;

public class JoinDemo {



    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(1);
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t1.join()之前");
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
