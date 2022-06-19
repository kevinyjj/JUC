package com.example.demo.thread.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    Lock lock = new ReentrantLock();

    void m1(){
        lock.lock();
        try {
            for(int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                if(i == 6){
                    m2();
                }
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    void m2(){
        boolean locked = false;
        try{
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2.."+locked);

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if(locked) lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentrantLockTest r1 = new ReentrantLockTest();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();

    }


}
