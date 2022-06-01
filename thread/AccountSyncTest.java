package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

/*模拟账户打钱*/
public class AccountSyncTest {
    String name;
    double balance;

    public synchronized void set(String name,double balance){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name){
        return this.balance;
    }


    public static void main(String[] args) {
        AccountSyncTest accountSyncTest = new AccountSyncTest();
        new Thread(()->accountSyncTest.set("zhangsan",100.00)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accountSyncTest.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(accountSyncTest.getBalance("zhangsan"));
    }


}
