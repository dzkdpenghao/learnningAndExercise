/**
 * FileName: LockDemoClass
 * Author:   80303990
 * Date:     2020/9/29 19:04
 * Description: 演示锁以及线程间通信
 */
package lock;

public class LockDemoClass {

    private static Object lock=new Object();
    private static int flag=1;

    //使3个线程依次打印
    public static void main(String[] args) {
        new Thread(new Mythread(),"1").start();
        new Thread(new Mythread(),"2").start();
        new Thread(new Mythread(),"3").start();
    }

    private static class Mythread implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                for (int i = 0; i < 20; i++) {
                    try {
                        //每次判断是否轮到该线程执行
                        while (flag!=Integer.valueOf(Thread.currentThread().getName())) {
                            lock.wait();
                        }
                        System.out.println("thread"+Thread.currentThread().getName()+"********"+i);
                        if(flag<3){
                            flag++;
                        }else flag=1;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}