package com.lsl.juc.two;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 一、创建执行线程的方式三：实现Callable接口。 相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常。
 * 
 * 二、                   执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果。  FutureTask是Future接口的实现类
 */
public class TestCallable {
	
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		
		//1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
		FutureTask<Integer> result = new FutureTask<>(td);

		// 因为FutureTask实现了Runable接口 也实现了Future接口。所以也可以用new Thread(传一个实现类) 来开启一个线程。
		new Thread(result).start();
		
		//2.接收线程运算后的结果
		try {
			Integer sum = result.get();  //FutureTask 可用于 闭锁
			System.out.println(sum);
			// 改成 i <= Integer.MAX_VALUE 时，发现没有计算完毕，result.get()没法执行，sum不会打印、、、所以它也可以用于闭锁。
			System.out.println("----发现没有计算完毕，result.get()没法执行，sum不会打印----");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class ThreadDemo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;

		// i <= Integer.MAX_VALUE
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}



/*

   创建线程方式 有4种：
   实现Runnable的方式：
class ThreadDemo implements Runnable{

	@Override
	public void run() {
	}
	
}
*/