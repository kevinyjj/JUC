package com.example.demo.thread.lock.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 允许多个线程同时执行
 * 限流：8车道，只有2个收费站出口
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(1000);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(1000);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T3 running...");
                Thread.sleep(1000);
                System.out.println("T3 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();
    }
}
