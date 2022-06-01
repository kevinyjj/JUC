package com.example.demo.thread;

public class SleepTest {

    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("A休眠10秒不放弃锁");
                    Thread.sleep(1000);
                    System.out.println("A休眠10秒醒来");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();



        new Thread(()->{

            synchronized (lock){
                System.out.println("B休眠10秒不放弃锁");
        try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.println("B休眠10秒醒来");

        }

        }).start();



    }
}
