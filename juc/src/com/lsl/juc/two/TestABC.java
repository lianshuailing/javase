package com.lsl.juc.two;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
 *	如：ABCABCABC…… 依次递归
 */
public class TestABC {

    public static void main(String[] args) {

        AbcDemo abcDemo = new AbcDemo();

        // A
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    abcDemo.loopA(i);
                }
            }
        }, "A").start();

        // B
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    abcDemo.loopB(i);
                }
            }
        }, "B").start();


        // C
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 10; i++) {
                    abcDemo.loopC(i);
                }
            }
        }, "C").start();
    }



}

class AbcDemo{

    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalNumber){
        // 加锁
        lock.lock();

        try{

            if(number != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());

            // 唤醒线程2
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopB(int totalNumber){
        lock.lock();
        try{
            if(number != 2){
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName());

            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopC(int totalNumber){
        lock.lock();

        try{
            if(number != 3){
                condition3.await();
            }

            System.out.println(Thread.currentThread().getName());
            System.out.println("____________________" + totalNumber);

            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}