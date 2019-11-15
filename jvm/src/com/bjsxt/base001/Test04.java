package com.bjsxt.base001;

public class Test04 {

	//-Xss1m  
	//-Xss5m
	
	//栈调用深度
	private static int count;
	
	public static void recursion(){
		count++;
		recursion();
	}

	// 利用递归来查看，栈调用的最大深度
	public static void main(String[] args){
		try {
			recursion();
		} catch (Throwable t) {
			System.out.println("调用最大深入：" + count);
			t.printStackTrace();
		}
	}
}
