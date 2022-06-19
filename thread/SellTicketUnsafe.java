package com.example.demo.thread;

public class SellTicketUnsafe implements Runnable{
    private int ticketNum = 100;//让多个线程共享ticketNum,慢慢卖票

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0) {
                System.out.println("售票");
                break;
            }
            try {
                Thread.sleep(50); //模拟50毫秒休眠，休息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() +"售出了1张票， 剩余票数 = " +(--ticketNum));

        }
    }

    public static void main(String[] args) {

        SellTicketUnsafe sellTicket02 = new SellTicketUnsafe();
        Thread thread = new Thread(sellTicket02);
        thread.start();

        Thread thread1 = new Thread(sellTicket02);
        thread1.start();

        Thread thread2 = new Thread(sellTicket02);
        thread2.start();

    }

}
