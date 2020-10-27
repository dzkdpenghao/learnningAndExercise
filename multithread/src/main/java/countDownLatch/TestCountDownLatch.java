/**
 * Author:   80303990
 * Date:     2020/9/30 17:23
 * Description: 演示CountDownLatch
 */
package countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "_____启动~~~~");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + "_____完成~~~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
                , "游戏主线程").start();

        new Thread(new PreThread(countDownLatch), "加载游戏地图").start();
        new Thread(new PreThread(countDownLatch), "加载游戏音乐").start();
        new Thread(new PreThread(countDownLatch), "加载游戏资源").start();
        new Thread(new PreThread(countDownLatch), "加载游戏时间").start();

    }

    //定义前置线程
    static class PreThread implements Runnable {
        private CountDownLatch cdl;

        public PreThread(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(5000));
                System.out.println(Thread.currentThread().getName() + "_________完成！");
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}