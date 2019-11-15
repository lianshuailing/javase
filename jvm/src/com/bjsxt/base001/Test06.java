package com.bjsxt.base001;

import java.util.HashMap;
import java.util.Map;

public class Test06 {

	public static void main(String[] args) {
		
		//参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
		Map<Integer, byte[]> m1 = new HashMap<Integer, byte[]>();
		for(int i=0; i< 5; i++){
			byte[] b = new byte[5*1024];
			m1.put(i, b);
		}


		//这种现象原yin因为：虚拟机对于体积不大的对象 会优先把数据分配到TLAB区域中，因此就失去了在老年代分配的机会
		//参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB
		// -XX:-UseTLAB禁用TLAB区
		Map<Integer, byte[]> m2 = new HashMap<Integer, byte[]>();
		for(int i=0; i< 5*1024; i++){
			byte[] b = new byte[1024];
			m2.put(i, b);
		}
	}
}
