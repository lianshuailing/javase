package com.lsl.juc.one;

/**
 * 演示：内存可见性 问题，2个线程访问它们的共享数据时，数据不同步。
 *
 * @author shkstart
 * @create 2019-10-07 18:58
 */
public class TestThread {

    // main线程是底层资源，加载的比较快，优先于ThredTwo实例线程
    public static void main(String[] args) {
        ThreadTwo threadTwo = new ThreadTwo();
        new Thread(threadTwo).start();

        while (true) {

            // 1 演示内存可见性
            // 此时getFlag时，flag还是false
//            if (threadTwo.getFlag()) {
//                System.out.println("-----------------");
//                break;
//            }

            // 1的现象，解决：同步方案synchronized，加锁。
            // 多线程下，这种加锁，效率很低，资源浪费。推荐volatile
            synchronized (threadTwo) {
                if (threadTwo.getFlag()) {
                    System.out.println("-----------------");
                    break;
                }
            }

        }


    }
}

class ThreadTwo implements Runnable {

    // 共享数据
    private Boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;

        System.out.println("flag苏醒了，flag=" + flag);
    }



    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}