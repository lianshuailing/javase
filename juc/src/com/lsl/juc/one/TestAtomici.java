package com.lsl.juc.one;

/**
 * 演示：i++ 的原子性问题：i++ 的操作实际上分为三个步骤“读-改-写”。 也叫多线程 安全问题！！！
 * 		  int i = 10;
 * 		  i = i++; //10
 *
 * 		  int temp = i;
 * 		  i = i + 1;
 * 		  i = temp;
 */
public class TestAtomici {
    public static void main(String[] args) {
        AtomicI atomicI = new AtomicI();

        for (int i=0; i<10; i++) {
            new Thread(atomicI).start();
        }


    }
}

class AtomicI implements Runnable{

    // 现象1：
//	private int serialNumber = 0;

	// 现象1解决，加上volatile关键字，但发现还是有问题，这是因为:多线程i++的原子性.jpg
    private volatile int serialNumber = 0;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + "=" + getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber++;
    }


}
