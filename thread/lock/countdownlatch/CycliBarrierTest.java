package com.example.demo.thread.lock.countdownlatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * 可以用来限流，入口有10个，但是只给进8个
 */
public class CycliBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(8, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有运动员入场，裁判员一声令下！！！");
            }
        });

        for (int i =0;i<10;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " 运动员到达起点，准备好了！！！");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 运动员出发！！！");
            }).start();
        }
    }
}
