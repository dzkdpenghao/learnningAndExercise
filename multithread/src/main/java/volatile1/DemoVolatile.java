/**
 * Author:   80303990
 * Date:     2020/9/29 19:36
 * Description: 演示volatile关键字
 */
package demo.thread.volatile1;

public class DemoVolatile {
    private static volatile int num = 100;

    //模拟4个售票窗口卖票
    public static void main(String[] args) {
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
        new Thread(new Mythread()).start();
    }

    static class Mythread implements Runnable {

        @Override
        public void run() {
            while (num >0)
                synchronized (this.getClass()) {
                    //防止票数小于零时仍在卖：因为可能有个线程在num=0的时候拿到锁，还没来得及执行减操作就释放了锁(比如时间片用光)
                    //然后另一个线程拿到锁，执行减操作使num=-1
                    //然后之前的线程得到时间片开始执行减操作使得num=-2...
                    if (num >0)
                        try {
                            System.out.println(Thread.currentThread().getName() + "____剩余票数：" + --num);
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
        }
    }
}