package com.example.demo.thread;

public class CrossPrintTest {
    static final Object object = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 27; i++) {
                    System.out.print(i);
                    synchronized (object) {
                        object.notify();
                        try {
                            if(i != 26){
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                char word = 'A';
                for (int i = 0; i < 26; i++) {
                    System.out.print(word);
                    word++;
                    synchronized (object) {
                        object.notify();
                        try {
                            if(i != 25){
                                object.wait();
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t2.start();

        t1.start();
    }
}
