package com.bjsxt.base001;


public class Test07 {

	public static void alloc(){
		byte[] b = new byte[2];
	}



	public static void main(String[] args) {
		
		//TLAB分配
		//参数：-XX:+UseTLAB -XX:+PrintTLAB -XX:+PrintGC -XX:TLABSize=102400 -XX:-ResizeTLAB -XX:TLABRefillWasteFraction=100 -XX:-DoEscapeAnalysis -server
		//       要想打印TLAB 的信息，则必须禁用逃逸分析 即-XX:-DoEscapeAnalysis
		for(int i=0; i<10000000;i++){
			alloc();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
