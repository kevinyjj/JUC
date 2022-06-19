package com.example.demo.thread.volatileT.singleton;

import java.util.concurrent.TimeUnit;

public class VolatileTest extends Thread{
    //看下有无volatile程序是否可以终止（可见性）
    volatile boolean start = true;
    //重写run方法，run方法的方法体就是现场执行体
    public void run()
    {
        System.out.println("volatileStart");
        while(start){
        }
        System.out.println("volatileEnd");
    }
    public static void main(String[] args)
    {
        VolatileTest test = new VolatileTest();
        test.start();
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.start = false;


    }
}
