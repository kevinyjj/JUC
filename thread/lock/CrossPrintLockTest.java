package com.example.demo.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CrossPrintLockTest {
    private static Lock lock = new ReentrantLock();// 通过JDK5中的Lock锁来保证线程的访问的互斥
    private static int state = 0;//通过state的值来确定是否打印

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 1; i < 27;) {
                try {
                    lock.lock();
                    while (state % 2 == 1) {
                        System.out.print(i);
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            char word = 'A';
            for (int i = 0; i < 26;) {
                try {
                    lock.lock();
                    while (state % 2 == 0) {
                        System.out.print(word);
                        word++;
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();// unlock()操作必须放在finally块中
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadB().start();
        new ThreadA().start();
    }
}
