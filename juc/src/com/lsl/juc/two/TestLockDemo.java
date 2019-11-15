package com.lsl.juc.two;

/**
 * @author shkstart
 * @create 2019-10-08 11:01
 */
public class TestLockDemo {
    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();

        new Thread(ticketDemo, "1号窗口").start();
        new Thread(ticketDemo, "2号窗口").start();
        new Thread(ticketDemo, "3号窗口").start();
        new Thread(ticketDemo, "4号窗口").start();
        new Thread(ticketDemo, "5号窗口").start();
    }

}

class TicketDemo implements Runnable {

    private int tickets = 100;

    //多线程下卖票，问题现象不明显
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() +"卖了一张票，还剩：" + --tickets);
//    }

    //多线程下卖票, 为了演示 问题现象：出现重复数据，即说明 不安全。
    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +"卖了一张票，还剩：" + --tickets);
            }

        }

    }
}
