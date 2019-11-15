package com.lsl.juc.two;

/**
 * 多线程 生产者 和 消费者 问题: 货物已满了，还在生产；没有货物了，还在消费。。。
 *
 */
public class ProductorAndConsumer {
    public static void main(String[] args) {
        Shoper shoper = new Shoper();

        Producter1 pro = new Producter1(shoper);
        Consumer1 con = new Consumer1(shoper);

        new Thread(pro, "生产者1").start();
        new Thread(con, "消费者1").start();
    }
}

//店员
class Shoper {
	private int product = 0;

	//进货
	public synchronized void get(){
		if (product >= 20){ //循环次数改为：1 ，为了演示： 最终生产者处于等待状态，而没有人再来唤醒它，程序一直等待状态，不停止。处理：去掉else
			System.out.println("产品已满！");

//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//			}

		}else {
            System.out.println(Thread.currentThread().getName() + " : " +  ++product);

//		    this.notifyAll();
        }



	}

	//卖货
	public synchronized void sale(){
		if (product <= 0){
			System.out.println("缺货！");

//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//			}

		}else {
            System.out.println(Thread.currentThread().getName() + " : " + --product);
//		this.notifyAll();

        }

	}
}


//生产者
class Producter1 implements Runnable{
	private Shoper shoper;

	public Producter1(Shoper shoper) {
		this.shoper = shoper;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            shoper.get();
		}
	}
}


//消费者
class Consumer1 implements Runnable{
	private Shoper shoper;

	public Consumer1(Shoper shoper) {
		this.shoper = shoper;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
            shoper.sale();
		}
	}

}
