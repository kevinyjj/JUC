package com.example.demo.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);

        lock.lock();
    }
}
