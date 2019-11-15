package com.lsl.juc.one;

import java.util.concurrent.CountDownLatch;

/**
 * 相应：闭锁使用场景
 *
 */
public class XyBiSuoChangJing {

    public static void main(String[] args) {
        //闭锁 参数：int型  必须跟开启的线程数一致！
        final CountDownLatch latch = new CountDownLatch(50);
        LatchDm latchDm = new LatchDm(latch);

        long start = System.currentTimeMillis();

        // 开启50个线程
        for (int i = 0; i < 50; i++) {
            new Thread(latchDm).start();
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end-start));
        // 50个线程同时去计算50000以内的偶数，main方法里统计耗时时间，发现问题：得不到这个时间！这时就需要 闭锁 的相关类。
        // main主线程 50个线程 是同时进行的，所以main线程没法统计时间、只能通过： 50个线程开始前 都加闭锁；每完成一个减一个闭锁，全部完成后，main线程再计算时间。
    }

}

class LatchDm implements Runnable {

    private CountDownLatch latch;

    public LatchDm(CountDownLatch latch) {
        this.latch = latch;
    }



    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }


}