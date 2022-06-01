package com.example.demo.thread;

public class TestBlock {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t1");
                c.increase();
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("t1");
                c.increase();
            }
        }, "t2线程");
        t2.start();

        Thread.sleep(100); // 确保 t2 run已经得到执行
        //(t2.getState()).isEqualTo(Thread.State.BLOCKED);
    }


}

class Counter {
    int counter;
    public synchronized void increase() {
        counter++;
        try {
            Thread.sleep(3000);
            System.out.println("counter");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
