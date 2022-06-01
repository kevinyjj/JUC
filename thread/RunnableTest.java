package com.example.demo.thread;

public class RunnableTest implements Runnable {
    private int t = 50;

    @Override
    public void run() {
         while(true){
             synchronized (this) {
                 if(t == 0){
                     break;
                 }
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName() + "=====" + t--);
             }
         }
    }
    public static void main(String[] args) {
        RunnableTest runnableTest=new RunnableTest();
        new Thread(runnableTest,"窗口1").start();
        new Thread(runnableTest,"窗口2").start();

    }
}