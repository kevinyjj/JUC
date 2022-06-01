package com.example.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectWaitTest {
    private static final Object obj = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());
        t1.start();
        t2.start();
    }

    static class MyThread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread1 start");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 end");
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("thread2 start");
                obj.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 end");
            }
        }
    }
}
