package com.example.demo.thread.volatileT.singleton;

/**
 * 单例线程安全，双重检查
 */
public class SingleTonVolatileTest {
    private static /*volatile*/ SingleTonVolatileTest INSTANCE;

    private SingleTonVolatileTest(){

    }

    public static SingleTonVolatileTest getInstance(){
        if(INSTANCE == null){
            synchronized (SingleTonVolatileTest.class){
                if(INSTANCE == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new SingleTonVolatileTest();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(SingleTonVolatileTest.getInstance().hashCode());
            }).start();
        }
    }
}
