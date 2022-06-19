package com.example.demo.thread.lock.exchanger;

import java.util.concurrent.Exchanger;


/**
 * 应用场景：基因算法，单眼皮，双眼皮
 */
public class ExchangerTest {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+ s);
        },"t1").start();

        new Thread(()->{
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+ s);
        },"t2").start();
    }
}
