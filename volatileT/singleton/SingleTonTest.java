package com.example.demo.volatileT.singleton;

/**
 * 单例带来线程安全问题，锁的颗粒细化
 */
public class SingleTonTest {
    private static SingleTonTest INSTANCE;

    private SingleTonTest(){

    }

    public static /*synchronized*/ SingleTonTest getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingleTonTest();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(SingleTonTest.getInstance().hashCode());
            }).start();
        }
    }

}
