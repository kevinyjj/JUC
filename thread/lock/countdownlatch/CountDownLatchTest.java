package com.example.demo.thread.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        CountDownLatchTest test = new CountDownLatchTest();
        Lock lock = new ReentrantLock();
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "开始执行");
                for(int j=0;j<100;j++){
                    result += 1;
                }
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + "执行结束");
            });
        }
        for(int k=0;k<threads.length;k++){
            threads[k].start();
        }
        latch.await();

        System.out.println("result="+result);

    }

}


