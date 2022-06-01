package com.example.demo.thread;

public class SyncTest implements Runnable{
    private int count = 200;

    public void t1(){

    }

    public void t2(){

    }


    public /*synchronized*/ void run(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        for(int i=0;i<200;i++){
            new Thread(syncTest::t1,"THREAD:"+ i).start();
        }
    }
}
