package com.example.demo.thread.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker0 = new Worker("worker0", (long) (Math.random()*2000+3000), countDownLatch);
        Worker worker1 = new Worker("worker1", (long) (Math.random()*2000+3000), countDownLatch);
        Worker worker2 = new Worker("worker2", (long) (Math.random()*2000+3000), countDownLatch);

        worker0.start();
        worker1.start();
        countDownLatch.await();

        System.out.println("准备工作就绪");
        worker2.start();
    }
}

class Worker extends Thread {
    private String name;
    private long time;

    private CountDownLatch countDownLatch;

    public Worker(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
            System.out.println(name+"第一阶段工作完成");

            countDownLatch.countDown();

            Thread.sleep(2000); //这里就姑且假设第二阶段工作都是要2秒完成
            System.out.println(name+"第二阶段工作完成");
            System.out.println(name+"工作完成，耗费时间="+(time+2000));

        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
