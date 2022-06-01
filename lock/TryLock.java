package com.example.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    //实例化Lock对象
    Lock lock = new ReentrantLock();

    /**
     * @param args
     */
    public static void main(String[] args) {
        //实例化本类对象，目的是调用runThread方法
        TryLock tl = new TryLock();
        //匿名对象创建线程1，并重写run方法，启动线程
        new Thread(){
            public void run(){

                tl.runThread(Thread.currentThread());
            }
        }.start();
        //匿名对象创建线程2，并重写run方法，启动线程
        new Thread(){
            public void run(){

                tl.runThread(Thread.currentThread());
            }
        }.start();


    }
    //线程共同调用方法
    public void runThread(Thread t){
        //lock对象调用trylock()方法尝试获取锁
        if(lock.tryLock()){
            //获锁成功代码段
            System.out.println("线程"+t.getName()+"获取锁成功");
            try {
                //执行的代码
                Thread.sleep(5000);
            } catch (Exception e) {
                //异常处理内容，比如中断异常，需要恢复等
            } finally {
                //获取锁成功之后，一定记住加finally并unlock()方法,释放锁
                System.out.println("线程"+t.getName()+"释放锁");
                lock.unlock();
            }
        }else{
            //获锁失败代码段
            //具体获取锁失败的回复响应
            System.out.println("线程"+t.getName()+"获取锁失败");
        }
    }
}
