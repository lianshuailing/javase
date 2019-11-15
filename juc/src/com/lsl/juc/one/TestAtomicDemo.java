package com.lsl.juc.one;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * 一、i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”
 * 		  int i = 10;
 * 		  i = i++; //10
 * 
 * 		  int temp = i;
 * 		  i = i + 1;
 * 		  i = temp;
 * 
 * 二、原子变量：在jdk1.5以后， java.util.concurrent.atomic包下提供了一些原子变量。
 *
 * 这些原子变量有如下特性：
 * 		1. volatile 保证了内存可见性   （通过看源码，可以看到 AtomicBoolean、AtomicInteger、AtomicIntegerArray、AtomicLong、AtomicLongArray、、、等都有volatile修饰）
 * 		2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 * 			CAS 算法是硬件对于并发操作的支持
 * 			CAS 包含了三个操作数：
 * 			①内存值  比说说是V
 * 			②预估值  比说说是A
 * 			③更新值  比说说是B
 * 			当且仅当 V == A 时，才会 V = B; 否则，不会执行任何操作。
 */
public class TestAtomicDemo {

	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		
		for (int i = 0; i < 10; i++) {
			new Thread(ad).start();
		}
	}
	
}

class AtomicDemo implements Runnable{

//	private int serialNumber = 0;
//	private volatile int serialNumber = 0;

	//since JDK1.8
	private AtomicInteger serialNumber = new AtomicInteger(0);

	@Override
	public void run() {
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		
		System.out.println(getSerialNumber());
	}
	
	public int getSerialNumber(){

//		return serialNumber++;

		// 使用原子变量，保证 共享数据 原子性！
		// 再执行演示程序，不会出现重复值得情况！！！
		return serialNumber.getAndIncrement();
	}
	
	
}
