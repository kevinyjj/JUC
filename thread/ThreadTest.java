package com.example.demo.thread;

public class ThreadTest extends Thread{
    static volatile int i = 0;
    //重写run方法，run方法的方法体就是现场执行体
    public void run()
    {
        for(;i<100;i++){
            System.out.println(getName()+"  "+i);

        }
    }
    public static void main(String[] args)
    {
        for(int i = 0;i< 100;i++)
        {
            //System.out.println(Thread.currentThread().getName()+"  : "+i);
            if(i==20)
            {
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }
}
