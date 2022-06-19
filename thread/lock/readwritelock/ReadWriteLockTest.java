package com.example.demo.thread.lock.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * reentrantLock 执行效率慢
 * readWriteLock 执行效率高，read时是共享锁，write时是排他锁
 */
public class ReadWriteLockTest {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,int v){
        try {
            lock.lock();
            value = v;
            Thread.sleep(1000);
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //Runnable readR = ()-> read(lock);
        Runnable readR = ()-> read(readLock);
        //Runnable writeR = ()->write(lock,new Random().nextInt());
        Runnable writeR = ()->write(writeLock,new Random().nextInt());
        for(int i=0;i<18;i++) new Thread(readR).start();
        for(int i=0;i<2;i++) new Thread(writeR).start();

    }



}
