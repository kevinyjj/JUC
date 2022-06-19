package com.example.demo.thread.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile能保证可见性、禁止指令重排序
 * 不能保证原子性
 * 原子性用automic操作  count 是多个线程共同操作的结果
 */
public class AtomicIntegerTest {
     AtomicInteger count = new AtomicInteger();
    /*synchronized*/ void m(){
        for(int i=0;i<10000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerTest t = new AtomicIntegerTest();
        List<Thread> threads = new ArrayList<>();

        for(int i=0;i<10;i++){
            threads.add(new Thread(t::m,"thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);



    }
}
