package com.lsl.juc.two;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 一、用于解决多线程安全问题的方式：
 * 
 * synchronized: 隐式锁，1和2都是通过synchronized这种隐式锁来解决多线程 安全问题的。
 * 1. 同步代码块
 * 
 * 2. 同步方法
 * 
 * jdk 1.5 后：
 * 3. 同步锁Lock  注意：是一个显示锁，需要通过lock()方法上锁，必须通过unlock()方法进行释放锁。
 *                     虽然它比1、2 更灵活、更高级，但是synchronized不能取消，有存在的必要，synchronized是jvm支持的关键字
 *                     同步锁Lock，必须最后unlock()释放锁， 所以它还是存在一定的风险的。
 */
public class TestLock {
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(ticket, "1号窗口").start();
		new Thread(ticket, "2号窗口").start();
		new Thread(ticket, "3号窗口").start();
	}

}

class Ticket implements Runnable{
	
	private int tick = 100;

	// 定义锁
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {

		while(true){
			
			lock.lock(); //上锁
			
			try{
				if(tick > 0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					
					System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
				}

			}finally{
				lock.unlock(); //释放锁
			}


		}


	}
	
}