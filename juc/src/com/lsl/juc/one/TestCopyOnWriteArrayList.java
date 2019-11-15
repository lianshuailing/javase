package com.lsl.juc.one;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
 */
public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		HelloThread ht = new HelloThread();
		
		for (int i = 0; i < 10; i++) {
			new Thread(ht).start();
		}
	}
	
}

class HelloThread implements Runnable{

	//它执行报：java.util.ConcurrentModificationExceptio
//	private static List<String> list = Collections.synchronizedList(new ArrayList<String>());//并发修改错误！
	
	private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();//并发时，也可以进行修改操作，原因是：每次修改前复制一个新的进行修改，互不影响
	
	static{
		list.add("AA");
		list.add("BB");
		list.add("CC");
	}

	@Override
	public void run() {
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
			
			list.add("AA");
		}
		
	}
	
}